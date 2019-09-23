package br.com.uds.pizzaria.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UdsPersonalizacaoKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(targetEntity = UdsPizza.class)
	@JoinColumn(name = "ID_PIZZA", referencedColumnName="ID_PIZZA")
	private UdsPizza pizza;
	
	@ManyToOne(targetEntity = UdsAdicional.class)
	@JoinColumn(name = "ID_ADICIONAL", referencedColumnName="ID_ADICIONAL")
	private UdsAdicional adicional;
		
	public UdsPersonalizacaoKey() {}

	public UdsPersonalizacaoKey(UdsPizza pizza, UdsAdicional adicional) {
		super();
		this.pizza = pizza;
		this.adicional = adicional;
	}

	public UdsPizza getPizza() {
		return pizza;
	}

	public void setPizza(UdsPizza pizza) {
		this.pizza = pizza;
	}

	public UdsAdicional getAdicional() {
		return adicional;
	}

	public void setAdicional(UdsAdicional adicional) {
		this.adicional = adicional;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adicional == null) ? 0 : adicional.hashCode());
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
		UdsPersonalizacaoKey other = (UdsPersonalizacaoKey) obj;
		if (adicional == null) {
			if (other.adicional != null)
				return false;
		} else if (!adicional.equals(other.adicional))
			return false;
		if (pizza == null) {
			if (other.pizza != null)
				return false;
		} else if (!pizza.equals(other.pizza))
			return false;
		return true;
	}

}
