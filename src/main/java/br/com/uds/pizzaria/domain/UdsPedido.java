package br.com.uds.pizzaria.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UDS_PEDIDO")
public class UdsPedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull(message = "ID é obrigatório")
	@Column (name = "ID_PEDIDO")
	private Long id;
	
	@Column (name = "VL_PEDIDO")
	private BigDecimal valor;
	
	@Column (name = "QT_TEMPO")
	private Integer tempo;
	
	public UdsPedido() {}
	
	public UdsPedido(Long id, BigDecimal valor, Integer tempo) {
		super();
		this.id = id;
		this.valor = valor;
		this.tempo = tempo;
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
		UdsPedido other = (UdsPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
