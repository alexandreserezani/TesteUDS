package br.com.uds.pizzaria.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.uds.pizzaria.domain.UdsPedido;
import br.com.uds.pizzaria.domain.UdsPedidoDetalhe;
import br.com.uds.pizzaria.domain.UdsPedidoDetalhePerson;

public class UdsPedidoDto {
	
	private Long id;
	
	private BigDecimal valor;
	
	private Integer tempo;
	
	private List<UdsPedidoDetalhe> detalhe;
	
	private List<UdsPedidoDetalhePerson> personalizacao;

	public UdsPedidoDto(UdsPedido obj) {
		super();
		this.id = obj.getId();
		this.valor = obj.getValor();
		this.tempo = obj.getTempo();
		this.detalhe = null;
		this.personalizacao = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public static List<UdsPedidoDto> converter(List<UdsPedido> obj){
		return obj.stream().map(UdsPedidoDto::new).collect(Collectors.toList());
	}

	

}
