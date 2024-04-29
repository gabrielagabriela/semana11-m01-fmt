package com.semana11.modulo1.semana11modulo1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "caderno")
@Data
public class Caderno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "caderno_id")
    private Long id;


    private String nome;


    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}