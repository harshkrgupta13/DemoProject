package com.example.demoProjectService.model;

public class AuthenticationStatus {

	private boolean authenticated;
	private User user;

	public AuthenticationStatus() {

	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AuthenticationStatus [authenticated=" + authenticated + ", user=" + user + "]";
	}

}
