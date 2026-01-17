package org.example.portfolio_paula.service;



import org.example.portfolio_paula.model.Info;
import org.example.portfolio_paula.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepo;

    public List<Info> obtenerTodo() {
        return infoRepo.findAll();
    }

    public Info buscarPorId(Long id) {
        return infoRepo.findById(id).orElse(null);
    }

    public void guardar(Info info) {
        infoRepo.save(info);
    }

    public void eliminar(Long id) {
        infoRepo.deleteById(id);
    }
}
