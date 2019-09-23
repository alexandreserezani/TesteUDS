package br.com.uds.pizzaria.dto;

import java.math.BigDecimal;

import br.com.uds.pizzaria.domain.UdsTamanho;

public class UdsTamanhoDtoPost {
	
	private Long id;
	
	private String codigo;
	
	private String descricao;
	
	private BigDecimal valor;
	
	private Integer tempo;

	public UdsTamanhoDtoPost() {}
	
	public UdsTamanhoDtoPost(UdsTamanho obj) {
		this.id = obj.getId();
		this.codigo = obj.getCodigo();
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	
	public UdsTamanho converter() {
		return new UdsTamanho(this.id, this.codigo, this.descricao, this.valor, this.tempo);
	}

}
