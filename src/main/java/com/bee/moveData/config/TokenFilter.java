package com.bee.moveData.config;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.bee.moveData.Service.TokenService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TokenFilter  extends GenericFilterBean {
    @Autowired
    TokenService tokenService;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String authorization = request.getHeader("Authorization");

        if(ObjectUtils.isEmpty(authorization)){
            filterChain.doFilter(servletRequest,servletResponse);
        }

        if(!authorization.startsWith("Bearer ")){
            filterChain.doFilter(servletRequest , servletResponse);
        }

        String token = authorization.substring(7);

        DecodedJWT decodedJWT = tokenService.verifyToken(token);

        if(decodedJWT == null){
            filterChain.doFilter(servletRequest , servletResponse);

        }

        String principal = decodedJWT.getClaim("principal").asString();
        String role = decodedJWT.getClaim("role").asString();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(principal ,"(protected)",authorities);

        SecurityContext contex =  SecurityContextHolder.getContext();
        contex.setAuthentication(authenticationToken);

    }
}
