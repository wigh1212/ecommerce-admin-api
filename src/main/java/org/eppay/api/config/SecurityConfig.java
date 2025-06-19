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
//"/api/v1/qr/**"
//    private static final String[] IGNORE_PAGES = {"favicon.ico","/error","/api/v1/auth/**","/api/v1/papago/**","/api/v1/qr/**"}; // 제외할 경로
    private static final String[] BASE_PAGES = {"/ws/**","/api/v1/admin/login","/api/v1/admin"};
//    private static final String[] MASTER_PAGES = { "/api/v1/baseStoreDivision/**"}; // 마스터 경로
//    private static final String[] PARTNER_PAGES = { "/api/v1/baseWorks/**", "/api/v1/baseStoreDivision/**"}; // 파트너 경로
//    private static final String[] HOTEL_PAGES = {"/api/v1/order/hotel/**"}; // 호텔 경로
//    private static final String[] STORE_PAGES = {"/api/v1/order/store/**"}; // 매장 경로
//    private static final String[] MASTER_AND_HOTEL_PAGES = {"/api/v1/hotel/**","/api/v1/baseWorks/**"
//                                                          ,"/api/v1/works/hotel/**","/api/v1/near/store/**","/api/v1/works/hotel/product/**"
//                                                          ,"/api/v1/works/hotel/**","/api/v1/hotel/worksHotel/**","/api/v1/checkout/**"};
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers( BASE_PAGES).permitAll()      // 제외 페이지
//                                .requestMatchers( BASE_PAGES ).permitAll()
//                                .requestMatchers( MASTER_PAGES ).hasAnyRole(AdminTypeEnum.ADMIN_TYPE_MASTER.getCode(), AdminTypeEnum.ADMIN_TYPE_PARTNER.getCode())    // 마스터,파트너 권한
//                                .requestMatchers( MASTER_AND_HOTEL_PAGES ).hasAnyRole(AdminTypeEnum.ADMIN_TYPE_HOTEL.getCode(),AdminTypeEnum.ADMIN_TYPE_MASTER.getCode(),AdminTypeEnum.ADMIN_TYPE_PARTNER.getCode())    // 마스터,호텔권한,마스터
//                                .requestMatchers( HOTEL_PAGES ).hasAnyRole(AdminTypeEnum.ADMIN_TYPE_HOTEL.getCode())    // 매장 권한
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


