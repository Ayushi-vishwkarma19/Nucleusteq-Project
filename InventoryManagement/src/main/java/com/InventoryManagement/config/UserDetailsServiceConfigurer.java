//It is used to configure authentication mechanism.
package com.InventoryManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.InventoryManagement.Services.impl.UserDetailServiceImpl;

@Configuration
public class UserDetailsServiceConfigurer {
    private final UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    public UserDetailsServiceConfigurer(UserDetailServiceImpl userDetailServiceImpl) {
        this.userDetailServiceImpl = userDetailServiceImpl;
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	//Authenticate the user whenever userDetailService will be called
        auth.userDetailsService(userDetailServiceImpl).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
