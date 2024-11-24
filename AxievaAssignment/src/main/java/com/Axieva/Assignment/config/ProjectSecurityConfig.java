package com.Axieva.Assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFiterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception{
        //Permit All requests
        http.csrf((csrf) -> csrf
                        .ignoringRequestMatchers("/"))
                .authorizeHttpRequests((requests) -> requests
                       // .requestMatchers( "/api/**").authenticated()
                        .requestMatchers("/api/contact/getAll").hasRole("ADMIN")
                        .requestMatchers("/api/contact/getMessagesByEmail/**").hasRole("STUDENT"))
                .httpBasic(Customizer.withDefaults());
        return http.build();

    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
