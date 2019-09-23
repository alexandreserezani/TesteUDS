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

import br.com.uds.pizzaria.domain.UdsSabor;
import br.com.uds.pizzaria.dto.UdsSaborDto;
import br.com.uds.pizzaria.dto.UdsSaborDtoPost;
import br.com.uds.pizzaria.dto.UdsSaborDtoPut;
import br.com.uds.pizzaria.service.UdsSaborService;

@RestController
@RequestMapping(value = "/sabor")
public class UdsSaborResource {
	
	@Autowired
    private UdsSaborService service;

    @GetMapping
    public ResponseEntity<List<UdsSaborDto>> findAll(){
        List<UdsSaborDto> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }
    
    @PostMapping
    public ResponseEntity<UdsSaborDto> novo(@RequestBody UdsSaborDtoPost objDtoPost, UriComponentsBuilder uriBuilder){
    	UdsSabor obj = service.novo(objDtoPost);
        URI uri = uriBuilder.path("/sabor/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(new UdsSaborDto(obj));
    }
    
    @PutMapping
    public ResponseEntity<UdsSaborDto> update(@RequestBody UdsSaborDtoPut objDtoPut){
    	UdsSabor obj = service.update(objDtoPut);
        return ResponseEntity.ok().body(new UdsSaborDto(obj));
    }
    
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<UdsSaborDto> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().body(null);
    }
    
    
}
