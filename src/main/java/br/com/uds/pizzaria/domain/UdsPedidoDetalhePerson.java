package br.com.uds.pizzaria.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "UDS_PEDIDO_DETALHE_PERSON")
public class UdsPedidoDetalhePerson  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private UdsPedidoDetalhePersonKey id;
	
	@Column(name = "VL_PERSONALIZACAO")
	private BigDecimal valor;

	public UdsPedidoDetalhePerson() {}
	
	public UdsPedidoDetalhePerson(UdsPedidoDetalhePersonKey id, BigDecimal valor) {
		super();
		this.id = id;
		this.valor = valor;
	}

	public UdsPedidoDetalhePersonKey getId() {
		return id;
	}

	public void setId(UdsPedidoDetalhePersonKey id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
		UdsPedidoDetalhePerson other = (UdsPedidoDetalhePerson) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
