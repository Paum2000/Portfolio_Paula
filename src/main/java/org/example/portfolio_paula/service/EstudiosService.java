package org.example.portfolio_paula.service;

import org.example.portfolio.model.Estudios;
import org.example.portfolio.repository.EstudiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiosService {

    @Autowired
    private EstudiosRepository estRepo;

    public List<Estudios> listar() {
        return estRepo.findAll();
    }

    public Estudios buscar(Long id) {
        return estRepo.findById(id).orElse(null);
    }

    public void guardar(Estudios est) {
        estRepo.save(est);
    }

    public void borrar(Long id) {
        estRepo.deleteById(id);
    }
}
