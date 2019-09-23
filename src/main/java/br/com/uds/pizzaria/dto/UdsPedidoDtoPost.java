package br.com.uds.pizzaria.dto;

import java.util.List;

public class UdsPedidoDtoPost {
	
	private Long id;
	
	private UdsPizzaDtoPost pizza;
	
	private List<UdsPersonalizacaoDtoPost> personalizacao;

	public UdsPedidoDtoPost() {}
	
	public UdsPedidoDtoPost(Long id, UdsPizzaDtoPost pizza, List<UdsPersonalizacaoDtoPost> personalizacao) {
		super();
		this.id = id;
		this.pizza = pizza;
		this.personalizacao = personalizacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UdsPizzaDtoPost getPizza() {
		return pizza;
	}

	public void setPizza(UdsPizzaDtoPost pizza) {
		this.pizza = pizza;
	}

	public List<UdsPersonalizacaoDtoPost> getPersonalizacao() {
		return personalizacao;
	}

	public void setPersonalizacao(List<UdsPersonalizacaoDtoPost> personalizacao) {
		this.personalizacao = personalizacao;
	}	
}
