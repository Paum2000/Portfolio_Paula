package org.example.portfolio_paula.controller;

import org.example.portfolio.model.Info;
import org.example.portfolio.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    // 1. Abrir el formulario para editar (usamos el ID 1 que es el tuyo)
    @RequestMapping("/editar")
    public String editar(Model model) {
        Info miInfo = infoService.buscarPorId(1L);
        model.addAttribute("info", miInfo);
        return "info";
    }

    // 2. Procesar el guardado de los datos
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Info info) {
        infoService.guardar(info);
        return "redirect:/admin/dashboard"; // Te devuelve al panel al terminar
    }
}
