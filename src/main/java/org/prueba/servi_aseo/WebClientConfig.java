package org.prueba.servi_aseo;


import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class WebClientConfig {

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http
    //         .csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).disable())  // Configura CSRF
    //         .authorizeHttpRequests(authorize -> 
    //             authorize
    //                 .requestMatchers("/", "/public/**").permitAll()  // Permitir acceso a estos endpoints
    //                 .anyRequest().authenticated()  // Requiere autenticación para otras solicitudes
    //         );
    
    //     return http.build(); // Construir el SecurityFilterChain
    // }
}
