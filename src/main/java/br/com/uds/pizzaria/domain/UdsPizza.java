package br.com.uds.pizzaria.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UDS_PIZZA")
public class UdsPizza implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull(message = "ID é obrigatório")
	@Column (name = "ID_PIZZA")
	private Long id;
	
	@ManyToOne(targetEntity = UdsSabor.class)
	@NotNull(message = "Sabor é obrigatório")
	@JoinColumn(name = "ID_SABOR")
	private UdsSabor sabor;
	
	@ManyToOne(targetEntity = UdsTamanho.class)
	@NotNull(message = "Tamanho é obrigatório")
	@JoinColumn(name = "ID_TAMANHO")
	private UdsTamanho tamanho;

	public UdsPizza() {}

	public UdsPizza(Long id, UdsSabor sabor, UdsTamanho tamanho) {
		super();
		this.id = id;
		this.sabor = sabor;
		this.tamanho = tamanho;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UdsSabor getSabor() {
		return sabor;
	}

	public void setSabor(UdsSabor sabor) {
		this.sabor = sabor;
	}

	public UdsTamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(UdsTamanho tamanho) {
		this.tamanho = tamanho;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sabor == null) ? 0 : sabor.hashCode());
		result = prime * result + ((tamanho == null) ? 0 : tamanho.hashCode());
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
		UdsPizza other = (UdsPizza) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sabor == null) {
			if (other.sabor != null)
				return false;
		} else if (!sabor.equals(other.sabor))
			return false;
		if (tamanho == null) {
			if (other.tamanho != null)
				return false;
		} else if (!tamanho.equals(other.tamanho))
			return false;
		return true;
	}
}
