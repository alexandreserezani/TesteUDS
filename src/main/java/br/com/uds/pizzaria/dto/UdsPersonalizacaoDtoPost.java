package br.com.uds.pizzaria.dto;

import br.com.uds.pizzaria.domain.UdsAdicional;
import br.com.uds.pizzaria.domain.UdsPersonalizacao;
import br.com.uds.pizzaria.domain.UdsPersonalizacaoKey;
import br.com.uds.pizzaria.domain.UdsPizza;

public class UdsPersonalizacaoDtoPost {
	
	private Long pizza;
	
	private Long adicional;

	public UdsPersonalizacaoDtoPost() {}
	
	public UdsPersonalizacaoDtoPost(UdsPersonalizacao obj) {
		super();
		this.pizza = obj.getPersonalizacao().getPizza().getId();
		this.adicional = obj.getPersonalizacao().getAdicional().getId();
	}

	public Long getPizza() {
		return pizza;
	}

	public void setPizza(Long pizza) {
		this.pizza = pizza;
	}

	public Long getAdicional() {
		return adicional;
	}

	public void setAdicional(Long adicional) {
		this.adicional = adicional;
	}
	
	public UdsPersonalizacao converter(UdsPizza objPizza, UdsAdicional objAdicional) {
		UdsPersonalizacaoKey objKey = new UdsPersonalizacaoKey(objPizza, objAdicional);
		return new UdsPersonalizacao(objKey);
	}
	
}
