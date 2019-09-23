package br.com.uds.pizzaria.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Embeddable
public class UdsPedidoDetalhePersonKey implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(targetEntity = UdsPedido.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PEDIDO", referencedColumnName="ID_PEDIDO")
	private UdsPedido pedido;
	
	@OneToOne(targetEntity = UdsPersonalizacao.class)
	@JoinColumns({
			@JoinColumn(name = "ID_PIZZA", referencedColumnName="ID_PIZZA"),
			@JoinColumn(name = "ID_ADICIONAL", referencedColumnName="ID_ADICIONAL")
	})
	private UdsPersonalizacao personalizacao;

	public UdsPedidoDetalhePersonKey() {}
	
	public UdsPedidoDetalhePersonKey(UdsPedido pedido, UdsPersonalizacao personalizacao) {
		super();
		this.pedido = pedido;
		this.personalizacao = personalizacao;
	}

	public UdsPedido getPedido() {
		return pedido;
	}

	public void setPedido(UdsPedido pedido) {
		this.pedido = pedido;
	}

	public UdsPersonalizacao getPersonalizacao() {
		return personalizacao;
	}

	public void setPersonalizacao(UdsPersonalizacao personalizacao) {
		this.personalizacao = personalizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((personalizacao == null) ? 0 : personalizacao.hashCode());
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
		UdsPedidoDetalhePersonKey other = (UdsPedidoDetalhePersonKey) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (personalizacao == null) {
			if (other.personalizacao != null)
				return false;
		} else if (!personalizacao.equals(other.personalizacao))
			return false;
		return true;
	}
}
