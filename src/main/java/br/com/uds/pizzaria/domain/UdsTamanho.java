package br.com.uds.pizzaria.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UDS_TAMANHO")
public class UdsTamanho implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id 
	@NotNull(message = "ID é obrigatório")
	@Column (name = "ID_TAMANHO")
	private Long id;
	
	@NotNull(message = "Código é obrigatório")
	@Column (name = "CD_TAMANHO")
	private String codigo;
	
	@NotNull(message = "Descrição é obrigatória")
	@Column (name = "DE_TAMANHO")
	private String descricao;
	
	@NotNull(message = "Valor é obrigatório")
	@Column (name = "VL_TAMANHO")
	private BigDecimal valor;
	
	@NotNull(message = "Tempo é obrigatório")
	@Column (name = "QT_TEMPO")
	private Integer tempo;
	
	public UdsTamanho() {}
	
	public UdsTamanho(Long id, String codigo, String descricao, BigDecimal valor, Integer tempo) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.tempo = tempo;
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
		UdsTamanho other = (UdsTamanho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
