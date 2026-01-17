package org.example.portfolio_paula.service;

import org.example.portfolio.model.Experiencia;
import org.example.portfolio.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService {

    @Autowired
    private ExperienciaRepository expRepo;

    public List<Experiencia> listar() {
        return expRepo.findAll();
    }

    public Experiencia buscar(Long id) {
        return expRepo.findById(id).orElse(null);
    }

    public void guardar(Experiencia exp) {
        expRepo.save(exp);
    }

    public void borrar(Long id) {
        expRepo.deleteById(id);
    }
}
