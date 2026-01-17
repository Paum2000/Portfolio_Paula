package org.example.portfolio_paula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "lenguajes")
@Getter @Setter
public class Lenguaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String icono_url;

    @ManyToMany(mappedBy = "lenguajes")
    private List<Proyecto> proyectos;
}
