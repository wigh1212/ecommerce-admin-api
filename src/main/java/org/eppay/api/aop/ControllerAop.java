package org.eppay.api.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.eppay.api.common.enums.ErrorCode;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.common.loginAccount.LoginAccount;
import org.eppay.api.common.loginAccount.LoginService;
import org.eppay.api.filter.JwtAuthFilter;
import org.eppay.api.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Aspect
@Component
public class ControllerAop {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LoginService loginService;

    @Before("execution(* org.eppay.api.controller..*(..))")
    public void beforeMethod(JoinPoint joinPoint) throws JsonProcessingException {
        System.out.println("Before: " + joinPoint.getSignature().toShortString());
        HttpServletRequest request = getCurrentHttpRequest();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) return;

        String requestUrl = request.getRequestURI(); // 요청된 URL 가져오기

        Long storeId = extractStoreIdFromUri(requestUrl);
        if (storeId == null) return;

        LoginAccount account=loginService.getAccount();
        if(account.getStoreId()==null){
            return;
        }
        else{
            if(account.getStoreId()!=storeId){
                throw new BaseException(ErrorCode.ACCESS_DENIED);
            }
            return;
        }
    }

    private Long extractStoreIdFromUri(String uri) {
        // 예: /api/v1/store/123/product
        // 정규식으로 storeId 추출
        Pattern pattern = Pattern.compile("/store/(\\d+)");
        Matcher matcher = pattern.matcher(uri);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return null;
    }




    private HttpServletRequest getCurrentHttpRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes servletRequestAttributes) {
            return servletRequestAttributes.getRequest();
        }
        return null;
    }



}
