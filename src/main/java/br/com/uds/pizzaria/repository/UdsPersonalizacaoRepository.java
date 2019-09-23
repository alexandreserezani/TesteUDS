package br.com.uds.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uds.pizzaria.domain.UdsPersonalizacao;
import br.com.uds.pizzaria.domain.UdsPersonalizacaoKey;

public interface UdsPersonalizacaoRepository extends JpaRepository<UdsPersonalizacao, UdsPersonalizacaoKey> {

}
