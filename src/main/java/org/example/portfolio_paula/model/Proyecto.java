package org.example.portfolio_paula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "proyectos")
@Getter @Setter
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // [cite: 26]

    private String nombre; // [cite: 26]

    @Column(columnDefinition = "TEXT")
    private String descripcion; // [cite: 26]

    private String github_url; // [cite: 26]
    private String imagen_url; // [cite: 26]
    private LocalDate fecha; // [cite: 26]

    @ManyToMany
    @JoinTable(
            name = "proyecto_lenguaje", // [cite: 30]
            joinColumns = @JoinColumn(name = "proyecto_id"), // [cite: 35]
            inverseJoinColumns = @JoinColumn(name = "lenguaje_id") // [cite: 35]
    )
    private List<Lenguaje> lenguajes;
}
