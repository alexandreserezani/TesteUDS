package br.com.uds.pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.uds.pizzaria.domain.UdsAdicional;
import br.com.uds.pizzaria.domain.UdsPersonalizacao;
import br.com.uds.pizzaria.domain.UdsPersonalizacaoKey;
import br.com.uds.pizzaria.domain.UdsPizza;
import br.com.uds.pizzaria.dto.UdsPersonalizacaoDto;
import br.com.uds.pizzaria.dto.UdsPersonalizacaoDtoPost;
import br.com.uds.pizzaria.repository.UdsAdicionalRepository;
import br.com.uds.pizzaria.repository.UdsPersonalizacaoRepository;
import br.com.uds.pizzaria.repository.UdsPizzaRepository;

@Service
public class UdsPersonalizacaoService {
	
	@Autowired
	private UdsPersonalizacaoRepository repository;
	@Autowired
	private UdsPizzaRepository repositoryPizza;
	@Autowired
	private UdsAdicionalRepository repositoryAdicional;
	
	public List<UdsPersonalizacaoDto> findAll() {
		List<UdsPersonalizacao> obj = repository.findAll();
		return UdsPersonalizacaoDto.converter(obj);
	}
	
	public UdsPersonalizacao novo(UdsPersonalizacaoDtoPost objDtoPost) {
		UdsPizza objPizza = new UdsPizza();
		UdsAdicional objAdicional = new UdsAdicional();
		
		objPizza = repositoryPizza.findById(objDtoPost.getPizza()).orElse(null);
		objAdicional = repositoryAdicional.findById(objDtoPost.getAdicional()).orElse(null);
		
		UdsPersonalizacaoKey objKey = new UdsPersonalizacaoKey(objPizza, objAdicional);
		
		UdsPersonalizacao obj = repository.findById(objKey).orElse(null);
		if (obj == null && objPizza != null && objAdicional != null){
			UdsPersonalizacao newObj = objDtoPost.converter(objPizza, objAdicional);
	        try{return repository.save(newObj);
	        } catch (DataIntegrityViolationException e){throw new IllegalArgumentException("Violação da UK");}
		}
		else if (objPizza == null){throw new IllegalArgumentException("Pizza não encontrada.");}
		else if (objAdicional == null){throw new IllegalArgumentException("Adicional de Pizza não encontrado.");}
        else {throw new IllegalArgumentException("Personalização existente.");}
    }
	
	public void delete(Long idPizza, Long idAdicional){
		UdsPizza objPizza = new UdsPizza();
		UdsAdicional objAdiconal = new UdsAdicional();
		
		objPizza = repositoryPizza.getOne(idPizza);
		objAdiconal = repositoryAdicional.getOne(idAdicional);
		
		UdsPersonalizacaoKey objKey = new UdsPersonalizacaoKey(objPizza, objAdiconal);
		
		UdsPersonalizacao obj = repository.findById(objKey).orElse(null);
			
		if(obj != null){
			try {repository.delete(obj);
			} catch (DataIntegrityViolationException e) {throw new IllegalArgumentException("Não é possível excluir a Personalização pois existe Pedido criado para esta Pizza");}			
		} else{ throw new IllegalArgumentException("Personalizacao não encontrado.");}
	}
	

}
