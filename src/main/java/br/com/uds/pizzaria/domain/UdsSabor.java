package br.com.uds.pizzaria.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UDS_SABOR")
public class UdsSabor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@NotNull(message = "ID é obrigatório")
	@Column (name = "ID_SABOR")
	private Long id;
	
	@NotNull(message = "Código é obrigatório")
	@Column (name = "CD_SABOR")
	private String codigo;
	
	@NotNull(message = "Descrição é obrigatório")
	@Column (name = "DE_SABOR")
	private String descricao;
	
	@NotNull(message = "Tempo é obrigatório")
	@Column (name = "QT_TEMPO_ADICIONAL")
	private Integer tempo;
	
	public UdsSabor() {
		super();
	}

	public UdsSabor(Long id, String codigo, String descricao, Integer tempo) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
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
		UdsSabor other = (UdsSabor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
