package org.example.portfolio_paula.controller;

import org.example.portfolio.model.Lenguaje;
import org.example.portfolio.service.LenguajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/lenguajes")
public class LenguajesController {

    @Autowired
    private LenguajeService lenguajeService;

    @RequestMapping("")
    public String listar(Model model) {
        model.addAttribute("lenguajes", lenguajeService.listar());
        return "admin/lenguajes-list";
    }

    @RequestMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("lenguaje", new Lenguaje());
        // CORRECCIÓN: debe apuntar a admin/lenguaje-form
        return "admin/lenguaje-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Lenguaje lenguaje) {
        lenguajeService.guardar(lenguaje);
        return "redirect:/admin/lenguajes";
    }

    @RequestMapping("/editar/{id}") // Añadido para permitir edición
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("lenguaje", lenguajeService.buscar(id));
        return "admin/lenguaje-form";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        lenguajeService.borrar(id);
        return "redirect:/admin/lenguajes";
    }
}
