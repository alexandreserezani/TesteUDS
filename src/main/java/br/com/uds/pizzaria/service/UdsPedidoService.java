package br.com.uds.pizzaria.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.uds.pizzaria.domain.UdsPedido;
import br.com.uds.pizzaria.domain.UdsPedidoDetalhe;
import br.com.uds.pizzaria.domain.UdsPedidoDetalheKey;
import br.com.uds.pizzaria.domain.UdsPedidoDetalhePerson;
import br.com.uds.pizzaria.domain.UdsPedidoDetalhePersonKey;
import br.com.uds.pizzaria.domain.UdsPersonalizacao;
import br.com.uds.pizzaria.domain.UdsPizza;
import br.com.uds.pizzaria.dto.UdsPedidoDto;
import br.com.uds.pizzaria.dto.UdsPedidoDtoPost;
import br.com.uds.pizzaria.repository.UdsPedidoDetalhePersonRepository;
import br.com.uds.pizzaria.repository.UdsPedidoDetalheRepository;
import br.com.uds.pizzaria.repository.UdsPedidoRepository;
import br.com.uds.pizzaria.repository.UdsPizzaRepository;

@Service
public class UdsPedidoService {
	
	@Autowired
	private UdsPedidoRepository repository;
	@Autowired
	private UdsPedidoDetalheRepository repositoryDetalhe;
	@Autowired
	private UdsPedidoDetalhePersonRepository repositoryDetalhePerson;
	
	@Autowired
	private UdsPizzaRepository repositoryPizza;
	
	@Autowired
    private UdsPizzaService servicePizza;
	@Autowired
    private UdsPersonalizacaoService servicePersonalizacao;
	
	
	public List<UdsPedidoDto>findByPedidoResumo(Long pedido){
		List<UdsPedido> obj = repository.findByPedido(pedido);
		List<UdsPedidoDto> objDto = UdsPedidoDto.converter(obj);
		List<UdsPedidoDto> newObjDto = new ArrayList<>();
		
		objDto.forEach((a) -> {
			a.setDetalhe(repositoryDetalhe.findAllPedidoDetalhe(a.getId()));
			a.setPersonalizacao(repositoryDetalhePerson.findAllPedidoDetalhePerson(a.getId()));
			newObjDto.add(a);
		});
		return newObjDto;
	}
	
	@Transactional
	public UdsPedido novo(UdsPedidoDtoPost objDtoPost) {
		UdsPedido obj = repository.findById(objDtoPost.getId()).orElse(null);
		if (obj == null) {
			UdsPizza objPizza = servicePizza.novo(objDtoPost.getPizza());
			List<UdsPersonalizacao> newobjPersonalizacao = new ArrayList<>();
			if (objPizza != null) {
				objDtoPost.getPersonalizacao().forEach((a) -> {
					UdsPersonalizacao objPersonalizacao = servicePersonalizacao.novo(a);
					newobjPersonalizacao.add(objPersonalizacao);
				});
				Integer tempoPizza = repositoryPizza.findByTempoPizza(objPizza.getId());
				BigDecimal valorPizza = repositoryPizza.findByValorPizza(objPizza.getId());
				BigDecimal valorPersonalizacao = repositoryPizza.findByValorAdiconal(objPizza.getId());
				valorPersonalizacao = valorPersonalizacao==null?new BigDecimal(0):valorPersonalizacao;
				Integer tempoPersonalização = repositoryPizza.findByTempoAdiconal(objPizza.getId());
				tempoPersonalização = tempoPersonalização==null?new Integer(0):tempoPersonalização;
				
				UdsPedido newObj = new UdsPedido(objDtoPost.getId(), valorPizza.add(valorPersonalizacao), tempoPizza+tempoPersonalização);
				
				try{repository.save(newObj);
		        } catch (DataIntegrityViolationException e){throw new IllegalArgumentException("Violação da UK");}
				
				UdsPedidoDetalheKey objDetKey = new UdsPedidoDetalheKey(newObj, objPizza);
				UdsPedidoDetalhe newObjDet = new UdsPedidoDetalhe(objDetKey, valorPizza, tempoPizza);
				
				try{repositoryDetalhe.save(newObjDet);
		        } catch (DataIntegrityViolationException e){throw new IllegalArgumentException("Violação da UK");}
				
				newobjPersonalizacao.forEach((a) -> {
					UdsPedidoDetalhePersonKey objDetPersonKey = new UdsPedidoDetalhePersonKey(newObj, a);
					UdsPedidoDetalhePerson objNewDetPerson = new UdsPedidoDetalhePerson(objDetPersonKey, a.getPersonalizacao().getAdicional().getValor());
					try{repositoryDetalhePerson.save(objNewDetPerson);
			        } catch (DataIntegrityViolationException e){throw new IllegalArgumentException("Violação da UK");}
				});
				
				return newObj;
			}
		}
		else {throw new IllegalArgumentException("Pedido existente.");}
		return null;
    }
	
	@Transactional
	public void delete(Long id){
		UdsPedido obj = repository.findById(id).orElse(null);
		List<UdsPizza> objPizza = repositoryDetalhe.findByPizzaPerPedido(id);
		
		objPizza.forEach((a) -> {
			try{repositoryPizza.delete(a);
	        } catch (DataIntegrityViolationException e){throw new IllegalArgumentException("Problemas ao excluir as Pizzas desse Pedido");}
		});
		
		if(obj != null){
			try {repository.delete(obj);
			} catch (DataIntegrityViolationException e) {throw new IllegalArgumentException("Não é possível excluir o Pedido pois existe Pedido criado para esta Pizza");}			
		} else{ throw new IllegalArgumentException("Pedido não encontrado.");}
	}
}
