package org.eppay.api.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.util.JwtTokenUtil;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String jwt = getJwtFromRequest(request);

        try {
            if ( jwt != null ) {
                String username = jwtTokenUtil.extractUsername(jwt);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        catch (SecurityException e) {
            log.info("Invalid JWT signature");
            request.setAttribute("errorCode", ErrorCode.AUTH_INVALID_SIGNATURE.getErrorCode());
        }
        catch (MalformedJwtException e) {
            log.info("유효하지 않은 구성의 JWT 토큰");
            request.setAttribute("errorCode", ErrorCode.AUTH_INVALID_TOKEN.getErrorCode());
        }
        catch (ExpiredJwtException e) {
            log.info("만료된 JWT 토큰");
            request.setAttribute("errorCode", ErrorCode.AUTH_TOKEN_EXPIRATION.getErrorCode());
        }
        catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 형식");
            request.setAttribute("errorCode", ErrorCode.AUTH_TOKEN_UNSUPPORTED.getErrorCode());
        }
        catch (IllegalArgumentException e) {
            log.info("JWT token compact of handler are invalid");
            request.setAttribute("errorCode", ErrorCode.AUTH_TOKEN_COMPACT.getErrorCode());
        }
        catch (Exception e) {
            log.info("잘못된 JWT 값 오류");
            request.setAttribute("errorCode", ErrorCode.AUTH_TOKEN_UNSUPPORTED.getErrorCode());
        }

        chain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }


}
