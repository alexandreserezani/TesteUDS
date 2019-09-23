package br.com.uds.pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.uds.pizzaria.domain.UdsSabor;
import br.com.uds.pizzaria.dto.UdsSaborDto;
import br.com.uds.pizzaria.dto.UdsSaborDtoPost;
import br.com.uds.pizzaria.dto.UdsSaborDtoPut;
import br.com.uds.pizzaria.repository.UdsSaborRepository;

@Service
public class UdsSaborService {
	
	@Autowired
	private UdsSaborRepository repository;
	
	public List<UdsSaborDto> findAll() {
		List<UdsSabor> obj = repository.findAll(Sort.by("descricao").ascending());
		return UdsSaborDto.converter(obj);
	}
	
	public UdsSabor novo(UdsSaborDtoPost objDtoPost) {
		UdsSabor obj = repository.findById(objDtoPost.getId()).orElse(null);
		
		if (obj == null){
	        UdsSabor newObj = objDtoPost.converter();
	        try{return repository.save(newObj);
	        } catch (DataIntegrityViolationException e){throw new IllegalArgumentException("Violação da UK");}
		}
        else {throw new IllegalArgumentException("Sabor de Pizza existente.");}
    }
	
	public UdsSabor update(UdsSaborDtoPut objDtoPut) {
		UdsSabor obj = repository.findById(objDtoPut.getId()).orElse(null);
		
		if (obj != null){
			obj.setCodigo(objDtoPut.getCodigo());;
			obj.setDescricao(objDtoPut.getDescricao());
			obj.setTempo(objDtoPut.getTempo());
		} 
		else {throw new IllegalArgumentException("Sabor de Pizza não encontrado.");}

		return repository.save(obj);
	}
	
	public void delete(Long id){
		UdsSabor obj = repository.findById(id).orElse(null);
			
		if(obj != null){
			try {repository.delete(obj);
			} catch (DataIntegrityViolationException e) {throw new IllegalArgumentException("Não é possível excluir o Sabor pois existem Pizzas criadas para este Sabor");}			
		} else{ throw new IllegalArgumentException("Sabor de Pizza não encontrado.");}
	}

}
