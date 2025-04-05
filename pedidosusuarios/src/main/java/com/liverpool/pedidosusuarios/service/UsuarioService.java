package com.liverpool.pedidosusuarios.service;
 import com.liverpool.pedidosusuarios.model.Usuario;
import com.liverpool.pedidosusuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;
 import java.util.Optional;
 @Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }
    public List<Usuario> obtenerUsuarios() {

        return usuarioRepository.findAll();
    }
    public Optional<Usuario> obtenerUsuarioPorId(Integer id) {

        return usuarioRepository.findById(id);
    }
    public Usuario actualizarUsuario(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }
    public void eliminarUsuario(Integer id) {

        usuarioRepository.deleteById(id);
    }
}
