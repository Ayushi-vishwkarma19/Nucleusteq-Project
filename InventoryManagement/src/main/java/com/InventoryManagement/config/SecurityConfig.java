package com.InventoryManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.InventoryManagement")
public class SecurityConfig {
    @Autowired
    private UserDetailsServiceConfigurer userDetailsServiceConfigurer;

   

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	//chaining for authentication
        http.csrf().disable()
            .authorizeRequests((requests) ->
                requests.requestMatchers("/api/users/*").permitAll()
                        .anyRequest().authenticated()
            )
            .formLogin();
          
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        userDetailsServiceConfigurer.configure(auth);
    }
}

