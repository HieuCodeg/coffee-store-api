package com.hieucodeg.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.httpBasic(abc -> abc.authenticationEntryPoint(restServicesEntryPoint()));
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/api/auth/staff/login",
                                "/api/auth/login",
                                "/api/auth/forget-password",
                                "/api/users/update-password/*",
                                "/api/users/update-password",
                                "/api/otp/*",
                                "/api/auth/register"
                        ).permitAll()
                        .requestMatchers(
                                "/",
                                "/login",
                                "/logout",
                                "/cp/login",
                                "/cp/logout",
                                "/register",
                                "/cp/forget-password",
                                "/cp/update-password/*",
                                "/error/*"
                        ).permitAll()
                        .requestMatchers(
                                "/resources/**",
                                "/assets/**"
                        ).permitAll()
                        .requestMatchers(
                                "/resources/**",
                                "/template/**"
                        ).permitAll()
                        .requestMatchers(
                                "/v3/api-docs",
                                "/swagger-resources/configuration/ui",
                                "/configuration/ui",
                                "/swagger-resources",
                                "/swagger-resources/configuration/security",
                                "/configuration/security",
                                "/swagger-ui/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginProcessingUrl("/cp/login")
                        .loginPage("/cp/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/")
                )
                .logout(logout -> logout
                        .logoutUrl("/cp/logout")
                        .logoutSuccessUrl("/cp/login")
                        .deleteCookies("JWT")
                        .invalidateHttpSession(true)
                );
//        http.authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll());
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exception -> exception
                        .accessDeniedHandler(customAccessDeniedHandler())
                );

        http.sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
//        http.cors();
        return http.build();
    }

}