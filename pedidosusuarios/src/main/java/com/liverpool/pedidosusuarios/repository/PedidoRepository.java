package com.liverpool.pedidosusuarios.repository;

import com.liverpool.pedidosusuarios.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
