package it.beije.turing.settemmezzo.login;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.beije.turing.settemmezzo.game.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3461793993227010707L;
	private String email;
	private String username;
	private String password;
	private Integer score;
	
	public UserDto(User user) {
		this.email = user.getEmail();
		this.score = user.getScore();
		this.username = user.getUsername();
	} 
	
	
	public String getUsername() {
		return this.username;
	}
	
	@JsonIgnore
	public Integer getScore() {
		return this.score;
	}
}
