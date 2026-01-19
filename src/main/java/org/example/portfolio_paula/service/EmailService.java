package org.example.portfolio_paula.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service // Indica que esta clase es un servicio de Spring Boot
public class EmailService {
    private final JavaMailSender mailSender;
    // Inyección de dependencias por constructor
    public EmailService(final JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    public void enviarCorreo(String correoCliente, String asunto, String cuerpo) {
        SimpleMailMessage mensaje = new SimpleMailMessage();

        // 1. El destino SIEMPRE eres tú
        mensaje.setTo("paum2000@gmail.com");

        // 2. El asunto puede indicar que es desde el portfolio
        mensaje.setSubject("Contacto Portfolio: " + asunto);

        // 3. Construimos el cuerpo para ver los datos del cliente
        String contenidoPersonalizado = "Has recibido un nuevo mensaje de contacto:\n\n" +
                "De: " + correoCliente + "\n" +
                "Mensaje:\n" + cuerpo;
        mensaje.setText(contenidoPersonalizado);

        // 4. Importante: El 'From' debe ser tu correo configurado en properties
        mensaje.setFrom("paum2000@gmail.com");

        // 5. Opcional: Si das a "Responder", le responderás al cliente
        mensaje.setReplyTo(correoCliente);

        mailSender.send(mensaje);
    }
}
