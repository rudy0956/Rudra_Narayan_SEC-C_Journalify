package net.engineeringdigest.journalApp.config;

//the engineering digest methods are deprecated due to difference in version

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth  // Use lambda-based DSL
                        .requestMatchers("/journal/**").permitAll()  // Allow access to /journal/**
                        .anyRequest().authenticated()  // Secure all other endpoints
                )
                .formLogin(Customizer.withDefaults())  // Default login page
                .logout(Customizer.withDefaults());    // Default logout behavior

        return http.build();
    }
}
