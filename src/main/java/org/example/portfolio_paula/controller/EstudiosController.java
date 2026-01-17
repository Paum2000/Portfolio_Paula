package org.example.portfolio_paula.controller;

import org.example.portfolio.model.Estudios;
import org.example.portfolio.service.EstudiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/estudios")
public class EstudiosController {

    @Autowired
    private EstudiosService estudiosService;

    @RequestMapping("")
    public String listar(Model model) {
        // Usamos "estudios" para que coincida con el th:each del HTML
        model.addAttribute("estudios", estudiosService.listar());
        return "admin/estudios-list";
    }

    @RequestMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("estudio", new Estudios());
        // CORRECCIÓN: debe apuntar a la carpeta admin [cite: 97]
        return "admin/estudios-form";
    }

    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("estudio", estudiosService.buscar(id));
        // CORRECCIÓN: debe apuntar a la carpeta admin
        return "admin/estudios-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Estudios estudio) {
        estudiosService.guardar(estudio);
        return "redirect:/admin/estudios";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        estudiosService.borrar(id);
        return "redirect:/admin/estudios";
    }
}