package com.eventos.config;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.eventos.models.Users;


public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	protected JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {
		Users users = new ObjectMapper().readValue(req.getInputStream(), Users.class);

		return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        users.getUsername(),
                        users.getPassword(),
                        Collections.<GrantedAuthority>emptyList()
                )
        );
	}
	
	@Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth
    ) throws IOException, ServletException {
        TokenAuthenticationService.addAuthentication(res, auth.getName());//criar classe
    }

}
