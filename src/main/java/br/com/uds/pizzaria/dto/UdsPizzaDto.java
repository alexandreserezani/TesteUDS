package br.com.uds.pizzaria.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.uds.pizzaria.domain.UdsPizza;
import br.com.uds.pizzaria.domain.UdsSabor;
import br.com.uds.pizzaria.domain.UdsTamanho;

public class UdsPizzaDto {
	
	private Long id;
	
	private UdsSabor sabor;
	
	private UdsTamanho tamanho;

	public UdsPizzaDto(UdsPizza obj) {
		this.id = obj.getId();
		this.sabor = obj.getSabor();
		this.tamanho = obj.getTamanho();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UdsSabor getSabor() {
		return sabor;
	}

	public void setSabor(UdsSabor sabor) {
		this.sabor = sabor;
	}

	public UdsTamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(UdsTamanho tamanho) {
		this.tamanho = tamanho;
	}
	
	public static List<UdsPizzaDto> converter(List<UdsPizza> obj){
		return obj.stream().map(UdsPizzaDto::new).collect(Collectors.toList());
	}

}
