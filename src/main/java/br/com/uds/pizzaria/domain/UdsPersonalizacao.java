package br.com.uds.pizzaria.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "UDS_PERSONALIZACAO")
public class UdsPersonalizacao {
	
	@EmbeddedId
	private UdsPersonalizacaoKey personalizacao;

	public UdsPersonalizacao() {}

	public UdsPersonalizacao(UdsPersonalizacaoKey personalizacao) {
		super();
		this.personalizacao = personalizacao;
	}

	public UdsPersonalizacaoKey getPersonalizacao() {
		return personalizacao;
	}

	public void setPersonalizacao(UdsPersonalizacaoKey personalizacao) {
		this.personalizacao = personalizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		UdsPersonalizacao other = (UdsPersonalizacao) obj;
		if (personalizacao == null) {
			if (other.personalizacao != null)
				return false;
		} else if (!personalizacao.equals(other.personalizacao))
			return false;
		return true;
	}
	
}
