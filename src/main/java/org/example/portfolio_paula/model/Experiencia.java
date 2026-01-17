package org.example.portfolio_paula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "experiencia")
@Getter
@Setter
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String puesto;
    private String empresa;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

}
