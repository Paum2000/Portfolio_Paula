package org.example.portfolio_paula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "info")
@Getter @Setter
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private String foto_url;
    private String email;
    private String telefono;
    private String linkedin;
    private String github;
}
