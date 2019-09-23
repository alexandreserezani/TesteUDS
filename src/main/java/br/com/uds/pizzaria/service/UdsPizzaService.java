package br.com.uds.pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.uds.pizzaria.domain.UdsPizza;
import br.com.uds.pizzaria.domain.UdsSabor;
import br.com.uds.pizzaria.domain.UdsTamanho;
import br.com.uds.pizzaria.dto.UdsPizzaDto;
import br.com.uds.pizzaria.dto.UdsPizzaDtoPost;
import br.com.uds.pizzaria.repository.UdsPizzaRepository;
import br.com.uds.pizzaria.repository.UdsSaborRepository;
import br.com.uds.pizzaria.repository.UdsTamanhoRepository;

@Service
public class UdsPizzaService {
	@Autowired
	private UdsPizzaRepository repository;
	@Autowired
	private UdsSaborRepository repositorySabor;
	@Autowired
	private UdsTamanhoRepository repositoryTamanho;
	
	public List<UdsPizzaDto> findAll() {
		List<UdsPizza> obj = repository.findAll();
		return UdsPizzaDto.converter(obj);
	}
	
	public UdsPizza novo(UdsPizzaDtoPost objDtoPost) {
		UdsSabor objSabor = new UdsSabor();
		UdsTamanho objTamanho = new UdsTamanho();
		
		objSabor = repositorySabor.findById(objDtoPost.getSabor()).orElse(null);
		objTamanho = repositoryTamanho.findById(objDtoPost.getTamanho()).orElse(null);
		
		UdsPizza obj = repository.findById(objDtoPost.getId()).orElse(null);
		if (obj == null && objSabor != null && objTamanho != null){
	        UdsPizza newObj = objDtoPost.converter(objSabor, objTamanho);
	        try{return repository.save(newObj);
	        } catch (DataIntegrityViolationException e){throw new IllegalArgumentException("Violação da UK");}
		}
		else if (objSabor == null){throw new IllegalArgumentException("Sabor de Pizza não encontrado.");}
		else if (objTamanho == null){throw new IllegalArgumentException("Tamanho de Pizza não encontrado.");}
        else {throw new IllegalArgumentException("Pizza existente.");}
    }
	
	public void delete(Long id){
		UdsPizza obj = repository.findById(id).orElse(null);
			
		if(obj != null){
			try {repository.delete(obj);
			} catch (DataIntegrityViolationException e) {throw new IllegalArgumentException("Não é possível excluir a Pizza pois existe Pedido criado para esta Pizza");}			
		} else{ throw new IllegalArgumentException("Pizza não encontrado.");}
	}
	
	//18 3841-9895 Shaiela

}
