package br.com.uds.pizzaria.domain;

import java.math.BigDecimal;
import java.util.List;

public class UdsPedidoResumo {
	
	private Long pedido;
	
	private BigDecimal valor;
	
	private Integer tempo;
	
	private List<UdsPedidoDetalhe> detalhe;
	
	private List<UdsPedidoDetalhePerson> personalizacao;

	public UdsPedidoResumo(Long pedido, BigDecimal valor, Integer tempo) {
		super();
		this.pedido = pedido;
		this.valor = valor;
		this.tempo = tempo;
	}

	public Long getPedido() {
		return pedido;
	}

	public void setPedido(Long pedido) {
		this.pedido = pedido;
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

	public List<UdsPedidoDetalhe> getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(List<UdsPedidoDetalhe> detalhe) {
		this.detalhe = detalhe;
	}

	public List<UdsPedidoDetalhePerson> getPersonalizacao() {
		return personalizacao;
	}

	public void setPersonalizacao(List<UdsPedidoDetalhePerson> personalizacao) {
		this.personalizacao = personalizacao;
	}
}
