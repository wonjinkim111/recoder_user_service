package com.yaas.recoderuserservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaas.recoderuserservice.dto.UsersDto;
import com.yaas.recoderuserservice.model.LoginRequestModel;
import com.yaas.recoderuserservice.service.IUsersService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private IUsersService userService;

    private Environment env;

    @Autowired
    public AuthenticationFilter(IUsersService userService, Environment env, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.env = env;
        setAuthenticationManager(authenticationManager);
    }

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginRequestModel creds = (LoginRequestModel)(new ObjectMapper()).readValue((InputStream)request.getInputStream(), LoginRequestModel.class);
            return getAuthenticationManager().authenticate((Authentication)new UsernamePasswordAuthenticationToken(creds

                    .getEmail(), creds
                    .getEncryptedPassword(), new ArrayList()));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String email = ((User)authResult.getPrincipal()).getUsername();
        UsersDto usersDto = this.userService.getUserDetailsByEmail(email);
        String token = Jwts.builder().setSubject(usersDto.getUserId()).setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(this.env.getProperty("token.expiration_time")))).signWith(SignatureAlgorithm.HS512, this.env.getProperty("token.secret")).compact();
        response.addHeader("token", token);
        response.addHeader("userId", usersDto.getUserId());
    }
}
