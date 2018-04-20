package com.me.webtools.pojo;



public class Login {
	
	private String username;
	private String password;
	private String email;
	private String loginRole;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String getLoginRole() {
		return loginRole;
	}

	private void setLoginRole(String loginRole) {
		this.loginRole = loginRole;
	}
}