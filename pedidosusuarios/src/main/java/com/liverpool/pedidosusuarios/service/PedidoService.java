package com.liverpool.pedidosusuarios.service;

import com.liverpool.pedidosusuarios.model.Pedido;
import com.liverpool.pedidosusuarios.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> obtenerPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obtenerPedidoPorId(Integer id) {
        return pedidoRepository.findById(id);
    }

    public Pedido actualizarPedido(Pedido pedido) {

        return pedidoRepository.save(pedido);
    }
    public void eliminarPedido(Integer id) {

        pedidoRepository.deleteById(id);
    }
}
