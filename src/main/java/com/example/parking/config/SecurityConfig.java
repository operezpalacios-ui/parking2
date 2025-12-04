package com.example.parking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @ Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Permitir acceso a la consola H2
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()  // permitir H2
                        .anyRequest().authenticated()                  // resto requiere login
                )
                // Login por formulario
                .formLogin(form -> form
                        .loginPage("/login")      // opcional (puedes quitar esta línea)
                        .permitAll()
                )
                // Configuraciones especiales para H2 console
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")   // deshabilitar CSRF para H2
                )
                .headers(headers -> headers
                        .frameOptions(frame -> frame.sameOrigin())   // permitir frames para H2
                );

        return http.build();
    }
}

