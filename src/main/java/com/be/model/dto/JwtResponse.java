package com.be.model.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    private String token;
    private String username;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String token, String username, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }
    public Collection<? extends GrantedAuthority> getRole() {
        return roles;
    }
}