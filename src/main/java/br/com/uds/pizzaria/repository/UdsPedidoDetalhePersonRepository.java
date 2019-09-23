package br.com.uds.pizzaria.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.uds.pizzaria.domain.UdsPedidoDetalhePerson;
import br.com.uds.pizzaria.domain.UdsPedidoDetalhePersonKey;

public interface UdsPedidoDetalhePersonRepository extends JpaRepository<UdsPedidoDetalhePerson, UdsPedidoDetalhePersonKey> {

	@Transactional
	@Query("SELECT obj FROM UdsPedidoDetalhePerson obj "
			+ "WHERE obj.id.pedido.id = :id")
	public List<UdsPedidoDetalhePerson> findAllPedidoDetalhePerson (@Param("id") Long id);

}
