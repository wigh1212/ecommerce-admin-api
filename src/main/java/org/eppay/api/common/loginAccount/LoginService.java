package org.eppay.api.common.loginAccount;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.eppay.api.util.JwtTokenUtil;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginService {

    private final HttpServletRequest request;
    private final JwtTokenUtil jwtTokenUtil;
    private final ObjectMapper objectMapper;

    public LoginAccount getAccount(){
        String authHeader = request.getHeader("Authorization");

        if(authHeader==null) {
            return null;
        }

        return  objectMapper.convertValue(jwtTokenUtil.extractAllClaims(authHeader.replace("Bearer ","")), LoginAccount.class );
    }

}
