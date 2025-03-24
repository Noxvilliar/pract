package com.example.pract;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// Ну... вкратце -- это конфигурация spring по безопасности(?), в которой и настраивается авторизация пользователей

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/patients/**").hasAnyAuthority("ROLE_PRACTITIONER", "ROLE_PATIENT")
                .antMatchers(HttpMethod.POST, "/patients").hasAuthority("ROLE_PRACTITIONER")
                .antMatchers(HttpMethod.PUT, "/patients/**").hasAuthority("ROLE_PRACTITIONER")
                .antMatchers(HttpMethod.DELETE, "/patients/**").hasAuthority("ROLE_PRACTITIONER")
                .anyRequest().authenticated()
                .and()
                .oauth2Login() // для авторизации через внешнего провайдера
                .and()
                .oauth2ResourceServer().jwt(); // для проверки JWT-токенов
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("practitioner").password("{noop}password").roles("PRACTITIONER").authorities("Patient.Read", "Patient.Write", "Patient.Delete").build());
        manager.createUser(User.withUsername("patient").password("{noop}password").roles("PATIENT").authorities("Patient.Read").build());
        return manager;
    }
}
/*public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/patients/**").hasAnyAuthority("ROLE_PRACTITIONER", "ROLE_PATIENT")
                .antMatchers(HttpMethod.POST, "/patients").hasAuthority("ROLE_PRACTITIONER")
                .antMatchers(HttpMethod.PUT, "/patients/**").hasAuthority("ROLE_PRACTITIONER")
                .antMatchers(HttpMethod.DELETE, "/patients/**").hasAuthority("ROLE_PRACTITIONER")
                .anyRequest().authenticated()
                .and()
                ..httpBasic();
    }*/