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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.uds.pizzaria.domain.UdsPedido;
import br.com.uds.pizzaria.dto.UdsPedidoDto;
import br.com.uds.pizzaria.dto.UdsPedidoDtoPost;
import br.com.uds.pizzaria.service.UdsPedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class UdsPedidoResource {

	@Autowired
    private UdsPedidoService service;
	
	@GetMapping("{id}")
    public ResponseEntity<List<UdsPedidoDto>> findByPedidoResumo(@PathVariable Long id){
        List<UdsPedidoDto> obj = service.findByPedidoResumo(id);
        return ResponseEntity.ok().body(obj);
    }
	
	@PostMapping
    public ResponseEntity<UdsPedido> novo(@RequestBody UdsPedidoDtoPost objDtoPost, UriComponentsBuilder uriBuilder){
    	UdsPedido obj = service.novo(objDtoPost);
        URI uri = uriBuilder.path("/pedido/{id}").buildAndExpand(obj.getId()).toUri();
        //return ResponseEntity.created(uri).body(new UdsPedidoDto(obj));
        return ResponseEntity.created(uri).body(obj);
    }
	
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<UdsPedido> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().body(null);
    }
}
