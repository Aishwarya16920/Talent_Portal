package com.zensar.tp.service;


public interface LoginServiceDelegate {
	public boolean isLoggedInUser(String authToken);

	public String role(String authToken);

	public String username(String authToken);
}