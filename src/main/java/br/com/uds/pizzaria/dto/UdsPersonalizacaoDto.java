package br.com.uds.pizzaria.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.uds.pizzaria.domain.UdsAdicional;
import br.com.uds.pizzaria.domain.UdsPersonalizacao;
import br.com.uds.pizzaria.domain.UdsPizza;

public class UdsPersonalizacaoDto {
	
	private UdsPizza pizza;
	
	private UdsAdicional adicional;

	public UdsPersonalizacaoDto(UdsPersonalizacao obj) {
		super();
		this.pizza = obj.getPersonalizacao().getPizza();
		this.adicional = obj.getPersonalizacao().getAdicional();
	}

	public UdsPizza getPizza() {
		return pizza;
	}

	public void setPizza(UdsPizza pizza) {
		this.pizza = pizza;
	}

	public UdsAdicional getAdicional() {
		return adicional;
	}

	public void setAdicional(UdsAdicional adicional) {
		this.adicional = adicional;
	}
	
	public static List<UdsPersonalizacaoDto> converter(List<UdsPersonalizacao> obj){
		return obj.stream().map(UdsPersonalizacaoDto::new).collect(Collectors.toList());
	}
	
}
