package br.com.uds.pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.uds.pizzaria.domain.UdsAdicional;
import br.com.uds.pizzaria.dto.UdsAdicionalDto;
import br.com.uds.pizzaria.dto.UdsAdicionalDtoPost;
import br.com.uds.pizzaria.dto.UdsAdicionalDtoPut;
import br.com.uds.pizzaria.repository.UdsAdicionalRepository;

@Service
public class UdsAdicionalService {
	
	@Autowired
	private UdsAdicionalRepository repository;
	
	public List<UdsAdicionalDto> findAll() {
		List<UdsAdicional> obj = repository.findAll();
		return UdsAdicionalDto.converter(obj);
	}
	
	public UdsAdicional novo(UdsAdicionalDtoPost objDtoPost) {
		UdsAdicional obj = repository.findById(objDtoPost.getId()).orElse(null);
		
		if (obj == null){
			UdsAdicional newObj = objDtoPost.converter();
			try{ return repository.save(newObj);
	        } catch (DataIntegrityViolationException e){throw new IllegalArgumentException("Violação da UK");}
		}
		else {throw new IllegalArgumentException("Adicional de Pizza existente.");} 
    }
	
	public UdsAdicional update(UdsAdicionalDtoPut objDtoPut) {
		UdsAdicional obj = repository.findById(objDtoPut.getId()).orElse(null);
		
		if (obj != null){
			obj.setDescricao(objDtoPut.getDescricao());
			obj.setValor(objDtoPut.getValor());
			obj.setTempo(objDtoPut.getTempo());
		} 
		else {throw new IllegalArgumentException("Adicional de Pizza não encontrado.");}

		return repository.save(obj);
	}
	
	public void delete(Long id){
		UdsAdicional obj = repository.findById(id).orElse(null);
			
		if(obj != null){
			try {repository.delete(obj);
			} catch (DataIntegrityViolationException e) {throw new IllegalArgumentException("Não é possível excluir o Adicional pois existem Pizzas criadas para este Adicional");}			
		} else{ throw new IllegalArgumentException("Adicional de Pizza não encontrado.");}
	}

}
