package org.example.portfolio_paula.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws
            Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                                // Rutas públicas (accesibles sin login)
                                .requestMatchers("/", "/index", "/login").permitAll()
                                .requestMatchers("/css/**", "/js/**",
                                        "/images/**").permitAll()
                                // Rutas del panel admin (requieren autenticación)
                                .requestMatchers("/admin/**").hasAnyRole(
                                        "ADMIN")
                                // Cualquier otra ruta requiere autenticación
                                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                                .loginPage("/login") // Página de login personalizada
                                .loginProcessingUrl("/login") // URL que procesa el login
                                .defaultSuccessUrl("/admin", true) // Redirige aquí tras login exitoso
                                .failureUrl("/login?error=true") // Redirige aquí si falla
                                .permitAll()
                )
                .logout(logout -> logout
                                .logoutUrl("/logout") // URL para hacer logout
                                .logoutSuccessUrl("/login?logout=true") //Redirige tras logout
                                .permitAll()
                );
        return http.build();
    }
}
