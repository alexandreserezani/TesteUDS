package br.com.uds.pizzaria.repository;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.uds.pizzaria.domain.UdsPizza;

public interface UdsPizzaRepository extends JpaRepository<UdsPizza, Long> {

	@Transactional
	@Query("SELECT SUM(obj.sabor.tempo)+SUM(obj.tamanho.tempo) "
	+ "FROM UdsPizza obj "
	+ "WHERE obj.id = :id ")
	public Integer findByTempoPizza(@Param("id") Long id);
	
	@Transactional
	@Query("SELECT SUM(obj.tamanho.valor) "
	+ "FROM UdsPizza obj "
	+ "WHERE obj.id = :id ")
	public BigDecimal findByValorPizza(@Param("id") Long id);
	
	@Transactional
	@Query("SELECT SUM(obj.personalizacao.adicional.valor) "
	+ "FROM UdsPersonalizacao obj "
	+ "WHERE obj.personalizacao.pizza.id = :id ")
	public BigDecimal findByValorAdiconal(@Param("id") Long id);
	
	@Transactional
	@Query("SELECT SUM(obj.personalizacao.adicional.tempo) "
	+ "FROM UdsPersonalizacao obj "
	+ "WHERE obj.personalizacao.pizza.id = :id ")
	public Integer findByTempoAdiconal(@Param("id") Long id);
}
