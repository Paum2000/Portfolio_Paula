package org.example.portfolio_paula.service;

import org.example.portfolio.model.Proyecto;
import org.example.portfolio.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyRepo;

    public List<Proyecto> listar() {
        return proyRepo.findAll();
    }

    public Proyecto buscar(Long id) {
        return proyRepo.findById(id).orElse(null);
    }

    public void guardar(Proyecto proy) {
        proyRepo.save(proy);
    }

    public void borrar(Long id) {
        proyRepo.deleteById(id);
    }
}
