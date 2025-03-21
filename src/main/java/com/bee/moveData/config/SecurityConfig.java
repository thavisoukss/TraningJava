package com.bee.moveData.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final TokenFilterConfiger tokenFilter;

    public SecurityConfig(TokenFilterConfiger tokenFilter) {
        this.tokenFilter = tokenFilter;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                            try {
                                auth
                                        .requestMatchers("/public/**", "/api/login", "/auth/register").permitAll()  // Allow these endpoints without authentication
                                        .anyRequest().authenticated()  // All other endpoints require authentication

                                        .and().apply(new TokenFilterConfiger(tokenFilter));
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                );

        return http.build();
    }
}
