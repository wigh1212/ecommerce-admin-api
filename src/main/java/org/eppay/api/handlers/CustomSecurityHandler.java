package org.eppay.api.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.ErrorResponse;

import java.io.PrintWriter;

@Component
public class CustomSecurityHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public final AuthenticationEntryPoint unauthorizedEntryPoint =
            (request, response, authException) -> {

                String errorCode = (String) request.getAttribute("errorCode");

                ErrorResponse fail = null;
                if(errorCode != null)
                    fail = new ErrorResponse(Integer.parseInt(errorCode), ErrorCode.getMessage(errorCode));
                else
                    fail = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), "인증 실패");

                String json = objectMapper.writeValueAsString(fail);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                PrintWriter writer = response.getWriter();
                writer.write(json);
                writer.flush();
            };

    public final AccessDeniedHandler accessDeniedHandler =
            (request, response, accessDeniedException) -> {
                ErrorResponse fail = new ErrorResponse(HttpStatus.FORBIDDEN.value(), "인가 실패");
                String json = objectMapper.writeValueAsString(fail);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                PrintWriter writer = response.getWriter();
                writer.write(json);
                writer.flush();
            };
}