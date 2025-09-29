package org.eppay.api.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.eppay.api.common.enums.admin.AdminTypeEnum;
import org.eppay.api.filter.JwtAuthFilter;
import org.eppay.api.handlers.CustomSecurityHandler;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomSecurityHandler customSecurityHandlers;
    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private static final String[] BASE_PAGES = {"/ws/**","/api/v1/admin/login","/api/v1/admin","/v3/**"};
    private static final String[] SWAGGER_PAGES = {"/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html", "/swagger-resources/**", "/webjars/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers( BASE_PAGES).permitAll()      // 제외 페이지
                                .requestMatchers(SWAGGER_PAGES).permitAll()
                                .anyRequest().authenticated()                     // 토큰체크

                )
                .headers(headers ->
                        headers
                                .contentSecurityPolicy(csp -> csp
                                        .policyDirectives("default-src 'self'; script-src 'self'")
                                )
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling((exceptionConfig) ->
                        exceptionConfig
                                .authenticationEntryPoint(customSecurityHandlers.unauthorizedEntryPoint)
                                .accessDeniedHandler(customSecurityHandlers.accessDeniedHandler)
                );

        return http.build();
    }

}


