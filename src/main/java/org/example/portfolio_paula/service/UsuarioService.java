package org.example.portfolio_paula.service;


import org.example.portfolio_paula.model.Usuario;
import org.example.portfolio_paula.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // IMPORTANTE: Dejamos que Spring inyecte el Bean que definiremos en SecurityConfig
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Registra un nuevo usuario en el sistema encriptando su contraseña.
     */
    public Usuario registrarUsuario(String username, String password, String email) {
        // 1. Validaciones de existencia
        if (usuarioRepository.existsByUsername(username)) {
            throw new RuntimeException("El nombre de usuario '" + username + "' ya existe.");
        }
        if (usuarioRepository.existsByEmail(email)) {
            throw new RuntimeException("El email '" + email + "' ya está registrado.");
        }

        // 2. Creación y mapeo de datos
        Usuario usuario = new Usuario();
        usuario.setUsername(username);

        // Encriptar la contraseña usando el BCrypt de la configuración global
        usuario.setPassword(passwordEncoder.encode(password));

        usuario.setEmail(email);

        // IMPORTANTE: Para que puedas entrar al panel /admin, el rol debe ser ROLE_ADMIN
        usuario.setRole("ROLE_ADMIN");

        usuario.setEnabled(true);

        // 3. Persistencia
        return usuarioRepository.save(usuario);
    }

    // --- Métodos de búsqueda y utilidad ---

    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public Boolean existsByUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }

    public Boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
}

