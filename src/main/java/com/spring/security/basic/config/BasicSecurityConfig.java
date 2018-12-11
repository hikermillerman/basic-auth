package com.spring.security.basic.config;

import com.spring.security.basic.entry.RestBasicAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {
    private RestBasicAuthenticationEntryPoint restBasicAuthenticationEntryPoint;

    @Autowired
    public void setRestBasicAuthenticationEntryPoint(RestBasicAuthenticationEntryPoint restBasicAuthenticationEntryPoint) {
        this.restBasicAuthenticationEntryPoint = restBasicAuthenticationEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/").permitAll()
                .anyRequest().authenticated();
        http.httpBasic().authenticationEntryPoint(restBasicAuthenticationEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("bespoke").password("{noop}bespoke").roles("USER");
    }
}
