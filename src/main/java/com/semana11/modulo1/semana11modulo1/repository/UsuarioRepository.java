package com.semana11.modulo1.semana11modulo1.repository;

import com.semana11.modulo1.semana11modulo1.entity.Nota;
import com.semana11.modulo1.semana11modulo1.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNomeUsuario(String nomeUsuario);
}
