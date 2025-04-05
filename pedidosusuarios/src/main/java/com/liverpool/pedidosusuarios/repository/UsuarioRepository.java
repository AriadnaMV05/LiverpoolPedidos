package com.liverpool.pedidosusuarios.repository;

import com.liverpool.pedidosusuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
