package br.com.uds.pizzaria.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.uds.pizzaria.domain.UdsAdicional;

public class UdsAdicionalDto {
	
	private Long id;
	
	private String descricao;
	
	private BigDecimal valor;
	
	private Integer tempo;

	public UdsAdicionalDto(UdsAdicional obj) {
		super();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.valor = obj.getValor();
		this.tempo = obj.getTempo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}
	
	public static List<UdsAdicionalDto> converter(List<UdsAdicional> obj){
		return obj.stream().map(UdsAdicionalDto::new).collect(Collectors.toList());
	}

}
