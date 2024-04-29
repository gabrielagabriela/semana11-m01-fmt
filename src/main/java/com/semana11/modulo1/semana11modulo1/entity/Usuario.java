package com.semana11.modulo1.semana11modulo1.entity;

import com.semana11.modulo1.semana11modulo1.controller.dto.LoginRequest;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "usuario_id")
    private Long id;

    @Column(unique = true)
    private String nomeUsuario;

    private  String senha;

    public boolean senhaValida(
            LoginRequest loginRequest,
            BCryptPasswordEncoder bCryptEncoder
    ) {
        return bCryptEncoder.matches(
                loginRequest.senha(),
                this.senha
        );
    }

}
