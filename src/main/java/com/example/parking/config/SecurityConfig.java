<<<<<<< HEAD
=======
package com.example.parking.config;

>>>>>>> 5e35cfb44b26c6a54eef665d5661ab8fa2345f86
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/h2-console/**").permitAll()  // permitir H2
                    .anyRequest().permitAll()                       // permitir todo
            )
            .csrf(csrf -> csrf
                    .ignoringRequestMatchers("/h2-console/**")     // deshabilitar CSRF para H2
            )
            .headers(headers -> headers
                    .frameOptions(frame -> frame.sameOrigin())     // permitir frames para H2
            );

<<<<<<< HEAD
    return http.build();
=======
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
>>>>>>> 5e35cfb44b26c6a54eef665d5661ab8fa2345f86
}
