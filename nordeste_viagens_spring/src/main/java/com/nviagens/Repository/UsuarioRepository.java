package com.nviagens.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nviagens.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    
}
