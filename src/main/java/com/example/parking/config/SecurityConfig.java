package com.example.parking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()   // acceso libre a H2
                        .requestMatchers("/vehiculos/**").permitAll()    // acceso libre a tu API
                        .anyRequest().permitAll()                        // NADA requiere login
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**", "/vehiculos/**")
                        .disable()                                       // desactiva CSRF por completo
                )
                .headers(headers -> headers
                        .frameOptions(frame -> frame.sameOrigin())       // necesario para H2
                )
                .formLogin(login -> login.disable())                     // desactiva login
                .httpBasic(basic -> basic.disable());                    // desactiva basic auth

        return http.build();
    }
}
