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

    return http.build();
}
