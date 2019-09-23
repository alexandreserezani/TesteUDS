package br.com.uds.pizzaria.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.uds.pizzaria.domain.UdsPedidoDetalhe;
import br.com.uds.pizzaria.domain.UdsPedidoDetalheKey;
import br.com.uds.pizzaria.domain.UdsPizza;

public interface UdsPedidoDetalheRepository extends JpaRepository<UdsPedidoDetalhe, UdsPedidoDetalheKey> {
	
	@Transactional
	@Query("SELECT obj FROM UdsPizza obj "
			+ "INNER JOIN UdsPedidoDetalhe obj2 ON (obj2.id.pizza.id = obj.id)"
			+ "WHERE obj2.id.pedido.id = :id")
	public List<UdsPizza> findByPizzaPerPedido (@Param("id") Long id);
	
	@Transactional
	@Query("SELECT obj FROM UdsPedidoDetalhe obj "
			+ "WHERE obj.id.pedido.id = :id")
	public List<UdsPedidoDetalhe> findAllPedidoDetalhe (@Param("id") Long id);
}
