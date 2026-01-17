package org.example.portfolio_paula.controller;

import org.example.portfolio.service.EstudiosService;
import org.example.portfolio.service.ExperienciaService;
import org.example.portfolio.service.InfoService;
import org.example.portfolio.service.ProyectoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final InfoService infoService;
    private final ExperienciaService expService;
    private final EstudiosService estService;
    private final ProyectoService proyService;

    public HomeController(InfoService infoService, ExperienciaService expService,
                          EstudiosService estService, ProyectoService proyService) {
        this.infoService = infoService;
        this.expService = expService;
        this.estService = estService;
        this.proyService = proyService;
    }

    @GetMapping("/")
    public String index(Model model) {
        // Se envía toda la información al modelo para Thymeleaf
        model.addAttribute("info", infoService.obtenerTodo().stream().findFirst().orElse(null));
        model.addAttribute("experiencias", expService.listar());
        model.addAttribute("estudios", estService.listar());
        model.addAttribute("proyectos", proyService.listar());
        return "index"; // Carga index.html
    }
}