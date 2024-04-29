package com.semana11.modulo1.semana11modulo1.entity;

import jakarta.persistence.*;
import lombok.Data;

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


}
