package com.spring.security.basic.entry;

/*
 * This class is used for handling the 403 forbidden
 */

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getOutputStream().println(authenticationException.getMessage());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("something");
        super.afterPropertiesSet();
    }
}
