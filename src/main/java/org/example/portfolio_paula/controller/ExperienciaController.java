package org.example.portfolio_paula.controller;

import org.example.portfolio.model.Experiencia;
import org.example.portfolio.service.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/experiencia")
public class ExperienciaController {

    @Autowired
    private ExperienciaService expService;

    // Listado en el panel administrativo
    @GetMapping("")
    public String listar(Model model) {
        // Enviamos "experiencias" para que el HTML pueda hacer el th:each
        model.addAttribute("experiencias", expService.listar());
        return "admin/experiencia-list";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        // Enviamos un objeto vacío para el th:object del formulario
        model.addAttribute("experiencia", new Experiencia());
        return "admin/experiencia-form";
    }

    // Procesar alta/actualización
    @PostMapping("/guardar")
    public String addExperiencia(@ModelAttribute Experiencia exp) {
        expService.guardar(exp);
        return "redirect:/admin/experiencia";
    }

    // Mostrar formulario de edición
    @RequestMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("experiencia", expService.buscar(id));
        // IMPORTANTE: Añadir "admin/" delante
        return "admin/experiencia-form";
    }

    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id) {
        expService.borrar(id);
        return "redirect:/admin/experiencia";
    }
}