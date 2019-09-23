package br.com.uds.pizzaria.resource;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.uds.pizzaria.domain.UdsTamanho;
import br.com.uds.pizzaria.dto.UdsTamanhoDto;
import br.com.uds.pizzaria.dto.UdsTamanhoDtoPost;
import br.com.uds.pizzaria.dto.UdsTamanhoDtoPut;
import br.com.uds.pizzaria.service.UdsTamanhoService;

@RestController
@RequestMapping(value = "/tamanho")
public class UdsTamanhoResource {
	
	@Autowired
    private UdsTamanhoService service;
	
	@GetMapping
    public ResponseEntity<List<UdsTamanhoDto>> findAll(){
        List<UdsTamanhoDto> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }
	
	@PostMapping
    public ResponseEntity<UdsTamanhoDto> novo(@RequestBody UdsTamanhoDtoPost objDtoPost, UriComponentsBuilder uriBuilder){
    	UdsTamanho obj = service.novo(objDtoPost);
        URI uri = uriBuilder.path("/tamanho/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(new UdsTamanhoDto(obj));
    }
	
	@PutMapping
    public ResponseEntity<UdsTamanhoDto> update(@RequestBody UdsTamanhoDtoPut objDtoPut){
		UdsTamanho obj = service.update(objDtoPut);
        return ResponseEntity.ok().body(new UdsTamanhoDto(obj));
    }
	
	@DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<UdsTamanhoDto> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().body(null);
    }

}
