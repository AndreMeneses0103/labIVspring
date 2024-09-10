package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Usuario;
import com.example.demo.entity.View;
import com.example.demo.service.UsuarioService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    @GetMapping
    @JsonView(View.ViewUsuario.class)
    public List<Usuario> todosUsuarios(){
        return service.todosUsuarios();
    }

    @PostMapping
    public Usuario novoUsuario(@RequestBody Usuario usuario){
        return service.novoUsuario(usuario);
    }

    @GetMapping(value = "/{id}")
    @JsonView(View.ViewUsuario.class)
    public Usuario usuarioPorId(@PathVariable("id") Long id){
        return service.usuarioPorId(id);
    }
}
