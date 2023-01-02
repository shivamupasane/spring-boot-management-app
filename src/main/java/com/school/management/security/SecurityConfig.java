package com.school.management.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .headers().frameOptions().disable() // h2 console run on a frame in html and by default security doesnt allow frame to be loaded in html
                .and()
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/h2-console").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/user/*").permitAll()// permit all requests from h2 path
                        .requestMatchers(HttpMethod.POST, SecurityConstant.REGISTER_PATH).permitAll() //permit all on register post request
                        .anyRequest().authenticated())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }
}
