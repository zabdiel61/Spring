package com.zd.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //autenticacion
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}123")
                .roles("ADMIN", "USER")
                .build();
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}123")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    //autorizacion
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/editar/**", "/agregar/**", "/eliminar")
                .hasRole("ADMIN")
                .antMatchers("/")
                .hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");

        return http.build();
    }
}
