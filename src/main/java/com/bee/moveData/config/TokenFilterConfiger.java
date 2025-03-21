package com.bee.moveData.config;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class TokenFilterConfiger extends SecurityConfigurerAdapter<DefaultSecurityFilterChain , HttpSecurity> {

  private final TokenFilter filter;

    public TokenFilterConfiger(TokenFilter filter) {
        this.filter = filter;
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(filter , UsernamePasswordAuthenticationFilter.class);
    }
}
