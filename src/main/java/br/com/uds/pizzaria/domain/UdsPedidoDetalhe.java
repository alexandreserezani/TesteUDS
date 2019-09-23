package br.com.uds.pizzaria.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "UDS_PEDIDO_DETALHE")
public class UdsPedidoDetalhe {
	
	@EmbeddedId
	private UdsPedidoDetalheKey id;
	
	@Column(name = "VL_PIZZA")
	private BigDecimal valor;
	
	@Column(name = "QT_TEMPO")
	private Integer tempo;

	public UdsPedidoDetalhe() {}
	
	public UdsPedidoDetalhe(UdsPedidoDetalheKey id, BigDecimal valor, Integer tempo) {
		super();
		this.id = id;
		this.valor = valor;
		this.tempo = tempo;
	}

	public UdsPedidoDetalheKey getId() {
		return id;
	}

	public void setId(UdsPedidoDetalheKey id) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UdsPedidoDetalhe other = (UdsPedidoDetalhe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
