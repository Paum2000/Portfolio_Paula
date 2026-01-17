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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGithub_url() {
        return github_url;
    }

    public void setGithub_url(String github_url) {
        this.github_url = github_url;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Lenguaje> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(List<Lenguaje> lenguajes) {
        this.lenguajes = lenguajes;
    }
}
