package com.zensar.tp.dto;



public class Userdto {
    private String token;
    
    public String getToken() {
        return token;
    }
    public Userdto(String token, String username, String role) {
        super();
        this.token = token;
        this.username = username;
        this.role = role;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    private String username;
    private String role;
    
}