package com.zensar.tp.services;


public interface LoginServiceDelegate {
	public boolean isLoggedInUser(String authToken);
	public String role(String authToken);
	public String username(String authToken);
}
