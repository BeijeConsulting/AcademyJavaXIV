package it.beije.turing.settemmezzo.login;

import java.io.Serializable;

public class UserRegistration implements Serializable {

	private static final long serialVersionUID = 7307787208098677340L;
	
	private String email;
    private String password;
    private String username;
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}