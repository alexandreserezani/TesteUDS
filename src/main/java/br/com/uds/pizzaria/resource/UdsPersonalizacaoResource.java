package br.com.uds.pizzaria.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uds.pizzaria.dto.UdsPersonalizacaoDto;
import br.com.uds.pizzaria.service.UdsPersonalizacaoService;

@RestController
@RequestMapping(value = "/personalizacao")
public class UdsPersonalizacaoResource {
	
	@Autowired
    private UdsPersonalizacaoService service;

    @GetMapping
    public ResponseEntity<List<UdsPersonalizacaoDto>> findAll(){
        List<UdsPersonalizacaoDto> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }
}
