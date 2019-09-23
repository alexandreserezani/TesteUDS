package br.com.uds.pizzaria.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UdsPedidoDetalheKey implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(targetEntity = UdsPedido.class)
	@JoinColumn(name = "ID_PEDIDO", referencedColumnName="ID_PEDIDO")
	private UdsPedido pedido;
	
	@ManyToOne(targetEntity = UdsPizza.class)
	@JoinColumn(name = "ID_PIZZA", referencedColumnName="ID_PIZZA")
	private UdsPizza pizza;

	public UdsPedidoDetalheKey() {}
	
	public UdsPedidoDetalheKey(UdsPedido pedido, UdsPizza pizza) {
		super();
		this.pedido = pedido;
		this.pizza = pizza;
	}

	public UdsPedido getPedido() {
		return pedido;
	}

	public void setPedido(UdsPedido pedido) {
		this.pedido = pedido;
	}

	public UdsPizza getPizza() {
		return pizza;
	}

	public void setPizza(UdsPizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((pizza == null) ? 0 : pizza.hashCode());
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
		UdsPedidoDetalheKey other = (UdsPedidoDetalheKey) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (pizza == null) {
			if (other.pizza != null)
				return false;
		} else if (!pizza.equals(other.pizza))
			return false;
		return true;
	}	
}
