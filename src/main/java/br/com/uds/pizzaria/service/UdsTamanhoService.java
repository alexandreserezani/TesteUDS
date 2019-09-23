package br.com.uds.pizzaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.uds.pizzaria.domain.UdsTamanho;
import br.com.uds.pizzaria.dto.UdsTamanhoDto;
import br.com.uds.pizzaria.dto.UdsTamanhoDtoPost;
import br.com.uds.pizzaria.dto.UdsTamanhoDtoPut;
import br.com.uds.pizzaria.repository.UdsTamanhoRepository;

@Service
public class UdsTamanhoService {
	
	@Autowired
	private UdsTamanhoRepository repository;
	
	public List<UdsTamanhoDto> findAll() {
		List<UdsTamanho> obj = repository.findAll();
		return UdsTamanhoDto.converter(obj);
	}
	
	public UdsTamanho novo(UdsTamanhoDtoPost objDtoPost) {
		UdsTamanho obj = repository.findById(objDtoPost.getId()).orElse(null);
		
		if (obj == null){
			UdsTamanho newObj = objDtoPost.converter();
			try{ return repository.save(newObj);
	        } catch (DataIntegrityViolationException e){throw new IllegalArgumentException("Violação da UK");}
		}
		else {throw new IllegalArgumentException("Tamanho de Pizza existente.");} 
    }
	
	public UdsTamanho update(UdsTamanhoDtoPut objDtoPut) {
		UdsTamanho obj = repository.findById(objDtoPut.getId()).orElse(null);
		
		if (obj != null){
			obj.setCodigo(objDtoPut.getCodigo());;
			obj.setDescricao(objDtoPut.getDescricao());
			obj.setValor(objDtoPut.getValor());
			obj.setTempo(objDtoPut.getTempo());
		} 
		else {throw new IllegalArgumentException("Tamanho de Pizza não encontrado.");}

		return repository.save(obj);
	}
	
	public void delete(Long id){
		UdsTamanho obj = repository.findById(id).orElse(null);
			
		if(obj != null){
			try {repository.delete(obj);
			} catch (DataIntegrityViolationException e) {throw new IllegalArgumentException("Não é possível excluir o Tamanho pois existem Pizzas criadas para este Tamanho");}			
		} else{ throw new IllegalArgumentException("Tamanho de Pizza não encontrado.");}
	}

}
