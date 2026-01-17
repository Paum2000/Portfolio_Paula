package org.example.portfolio_paula.controller;


import org.example.portfolio_paula.model.Proyecto;
import org.example.portfolio_paula.service.LenguajeService;
import org.example.portfolio_paula.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/proyectos")
public class ProyectosController {

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private LenguajeService lenguajeService;

    @RequestMapping("")
    public String listar(Model model) {
        model.addAttribute("proyectos", proyectoService.listar());
        return "admin/proyecto-list";
    }

    @RequestMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        model.addAttribute("todosLenguajes", lenguajeService.listar()); //
        return "admin/proyecto-form"; //
    }

    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("proyecto", proyectoService.buscar(id));
        model.addAttribute("todosLenguajes", lenguajeService.listar()); //
        return "admin/proyecto-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Proyecto proyecto) {
        proyectoService.guardar(proyecto);
        return "redirect:/admin/proyectos";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        proyectoService.borrar(id);
        return "redirect:/admin/proyectos";
    }
}
