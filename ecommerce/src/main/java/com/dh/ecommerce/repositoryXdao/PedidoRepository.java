package com.dh.ecommerce.repositoryXdao;

import com.dh.ecommerce.entityXmodel.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
