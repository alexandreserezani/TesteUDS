package br.com.uds.pizzaria.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uds.pizzaria.dto.UdsPizzaDto;
import br.com.uds.pizzaria.service.UdsPizzaService;

@RestController
@RequestMapping(value = "/pizza")
public class UdsPizzaResource {
	
	@Autowired
    private UdsPizzaService service;

    @GetMapping
    public ResponseEntity<List<UdsPizzaDto>> findAll(){
        List<UdsPizzaDto> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }    
}
