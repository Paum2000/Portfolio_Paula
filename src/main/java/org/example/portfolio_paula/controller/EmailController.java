package org.example.portfolio_paula.controller;

import org.example.portfolio_paula.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller // NO RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public String enviarCorreo(@RequestParam("to") String clienteEmail, // Este es el email que escribió el usuario
                               @RequestParam("subject") String subject,
                               @RequestParam("body") String body,
                               RedirectAttributes redirectAttributes) {
        try {
            // Pasamos el email del cliente como primer parámetro
            emailService.enviarCorreo(clienteEmail, subject, body);
            redirectAttributes.addFlashAttribute("message", "¡Tu mensaje ha sido enviado! Me pondré en contacto contigo pronto.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "No se pudo enviar el mensaje: " + e.getMessage());
        }
        return "redirect:/";
    }
}
