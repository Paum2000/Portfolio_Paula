package org.example.portfolio_paula.service;

import org.example.portfolio.model.Lenguaje;
import org.example.portfolio.repository.LenguajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LenguajeService {

    @Autowired
    private LenguajeRepository lenRepo;

    public List<Lenguaje> listar() {
        return lenRepo.findAll();
    }

    public Lenguaje buscar(Long id) {
        return lenRepo.findById(id).orElse(null);
    }

    public void guardar(Lenguaje len) {
        lenRepo.save(len);
    }

    public void borrar(Long id) {
        lenRepo.deleteById(id);
    }
}
