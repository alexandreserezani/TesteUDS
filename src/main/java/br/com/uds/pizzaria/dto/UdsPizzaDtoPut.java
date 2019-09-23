package br.com.uds.pizzaria.dto;

import br.com.uds.pizzaria.domain.UdsPizza;
import br.com.uds.pizzaria.domain.UdsSabor;
import br.com.uds.pizzaria.domain.UdsTamanho;

public class UdsPizzaDtoPut {
	
	private Long id;
	
	private Long sabor;
	
	private Long tamanho;

	public UdsPizzaDtoPut() {}
	
	public UdsPizzaDtoPut(UdsPizza obj) {
		this.id = obj.getId();
		this.sabor = obj.getSabor().getId();
		this.tamanho = obj.getTamanho().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSabor() {
		return sabor;
	}

	public void setSabor(Long sabor) {
		this.sabor = sabor;
	}

	public Long getTamanho() {
		return tamanho;
	}

	public void setTamanho(Long tamanho) {
		this.tamanho = tamanho;
	}
	
	public UdsPizza converter(UdsSabor objSabor, UdsTamanho objTamanho) {
		return new UdsPizza(this.id, objSabor, objTamanho);
	}

}
