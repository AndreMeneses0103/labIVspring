package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository rep;

    public UsuarioServiceImpl(UsuarioRepository rep){
        this.rep = rep;
    }

    @Transactional
    @Override
    public Usuario novoUsuario(Usuario usuario) {
        if(usuario == null || usuario.getNome() == null|| usuario.getNome().isBlank() || usuario.getSenha() == null || usuario.getSenha().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos");
        }
        return rep.save(usuario);
    }

    @Override
    public List<Usuario> todosUsuarios() {
        return rep.findAll();
    }

    @Override
    public Usuario usuarioPorId(Long id) {
        Optional<Usuario> usuarioOp = rep.findById(id);
        if(usuarioOp.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado");
        }
        return usuarioOp.get();
    }
    
}
