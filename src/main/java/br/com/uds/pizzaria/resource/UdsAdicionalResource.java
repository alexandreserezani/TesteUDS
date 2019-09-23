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

import br.com.uds.pizzaria.domain.UdsAdicional;
import br.com.uds.pizzaria.dto.UdsAdicionalDto;
import br.com.uds.pizzaria.dto.UdsAdicionalDtoPost;
import br.com.uds.pizzaria.dto.UdsAdicionalDtoPut;
import br.com.uds.pizzaria.service.UdsAdicionalService;

@RestController
@RequestMapping(value = "/adicional")
public class UdsAdicionalResource {
	
	@Autowired
    private UdsAdicionalService service;
	
	@GetMapping
    public ResponseEntity<List<UdsAdicionalDto>> findAll(){
        List<UdsAdicionalDto> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }
	
	@PostMapping
    public ResponseEntity<UdsAdicionalDto> novo(@RequestBody UdsAdicionalDtoPost objDtoPost, UriComponentsBuilder uriBuilder){
    	UdsAdicional obj = service.novo(objDtoPost);
        URI uri = uriBuilder.path("/adicional/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(new UdsAdicionalDto(obj));
    }
	
	@PutMapping
    public ResponseEntity<UdsAdicionalDto> update(@RequestBody UdsAdicionalDtoPut objDtoPut){
		UdsAdicional obj = service.update(objDtoPut);
        return ResponseEntity.ok().body(new UdsAdicionalDto(obj));
    }
	
	@DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<UdsAdicionalDto> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().body(null);
    }

}
