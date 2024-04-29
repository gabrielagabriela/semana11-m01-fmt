package com.semana11.modulo1.semana11modulo1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "nota")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nota_id")
    private Long id;

    private String titulo;

    private String content;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "caderno_id")
    private Caderno caderno;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
