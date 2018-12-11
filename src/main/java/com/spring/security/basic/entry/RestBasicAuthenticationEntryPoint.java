package com.spring.security.basic.entry;

/*
 * This class is used for handling the 403 forbidden
 */

import com.google.gson.Gson;
import com.spring.security.basic.responses.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class RestBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    private Gson gson;

    @Autowired
    public void setGson(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(APPLICATION_JSON_VALUE);
        ErrorResponse errorResponse = new ErrorResponse("100000000455", authenticationException.getMessage());
        response.getOutputStream().println(gson.toJson(errorResponse));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("something");
        super.afterPropertiesSet();
    }
}
