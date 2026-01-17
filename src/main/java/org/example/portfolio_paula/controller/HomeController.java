package org.example.portfolio_paula.controller;


import org.example.portfolio_paula.model.Info;
import org.example.portfolio_paula.service.EstudiosService;
import org.example.portfolio_paula.service.ExperienciaService;
import org.example.portfolio_paula.service.InfoService;
import org.example.portfolio_paula.service.ProyectoService;
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

    @GetMapping("")
    public String index(Model model) {
        // Intentamos obtener el primer registro de la base de datos
        Info info = infoService.obtenerTodo().stream().findFirst().orElse(null);

        // SI ES NULL (BD vacía), creamos uno temporal para que la web no explote
        if (info == null) {
            info = new Info();
            info.setNombre("Paula Morales");
            info.setDescripcion("Desarrolladora Full Stack");
            info.setFoto_url("/images/perfil.jpg"); // Ruta por defecto
        }

        model.addAttribute("info", info);
        model.addAttribute("experiencias", expService.listar());
        model.addAttribute("estudios", estService.listar());
        model.addAttribute("proyectos", proyService.listar());
        return "index";
    }
}