package br.com.uds.pizzaria.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.uds.pizzaria.domain.UdsPedido;

public interface UdsPedidoRepository extends JpaRepository<UdsPedido, Long> {
	@Transactional
	@Query("SELECT obj FROM UdsPedido obj WHERE obj.id = :id")
    public List<UdsPedido> findByPedido (@Param("id") Long id);

}
