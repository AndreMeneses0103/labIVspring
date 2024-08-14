package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
