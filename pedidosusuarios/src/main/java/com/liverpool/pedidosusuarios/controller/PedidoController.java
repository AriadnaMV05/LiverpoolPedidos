package com.liverpool.pedidosusuarios.controller;

import com.liverpool.pedidosusuarios.model.Pedido;
import com.liverpool.pedidosusuarios.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiliverpool/pedidos")
@Tag(name = "Pedidos", description = "CRUD Pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Operation(summary = "Crear un nuevo pedido", description = "Endpoint  que permite el registro un nuevo pedido")
    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoService.crearPedido(pedido);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }
    @Operation(summary = "Listar pedidos", description = "Endpoint que devuelve todos los pedidos registrados")
    @GetMapping
    public ResponseEntity<List<Pedido>> obtenerPedidos() {
        List<Pedido> pedidos = pedidoService.obtenerPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
    @Operation(summary = "Obtener pedido por ID", description = "Endpoint que devuelve un pedido en  específico mediante su ID")
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtenerPedidoPorId(@PathVariable Integer id) {
        Optional<Pedido> pedido = pedidoService.obtenerPedidoPorId(id);
        return pedido.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(summary = "Actualizar pedido", description = "Endpoint que  actualiza los datos de un pedido")
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizarPedido(@PathVariable Integer id, @RequestBody Pedido pedido) {
        if (!pedidoService.obtenerPedidoPorId(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pedido.setIdPedido(id);  // Aseguramos que el ID coincide
        Pedido pedidoActualizado = pedidoService.actualizarPedido(pedido);
        return new ResponseEntity<>(pedidoActualizado, HttpStatus.OK);
    }
    @Operation(summary = "Eliminar pedido", description = "Endpoint que elimina por completo a un pedido del sistema")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Integer id) {
        if (!pedidoService.obtenerPedidoPorId(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pedidoService.eliminarPedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
