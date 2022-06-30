package it.beije.turing.settemmezzo.game;

import static java.util.stream.Collectors.toList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import it.beije.turing.settemmezzo.game.lobby.Lobby;
import it.beije.turing.settemmezzo.login.Authority;
import it.beije.turing.settemmezzo.login.RefreshToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User implements Serializable, UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "score")
	private int score;

	@Transient
	private String token;

	@Transient
	private RefreshToken refreshToken;

	@Transient
	private boolean online = false;

	@Transient
	@JsonIgnore
	private Game game = Game.getInstance();

	@Transient
	@JsonIgnore
	private Lobby lobby = null;

	@Transient
	@JsonIgnore
	private String sessionId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	// SPRING SECURITY
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_authority", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "authority_id", referencedColumnName = "id", nullable = false, updatable = false) })
	@JsonIgnore
	private List<Authority> authorityEntity = new ArrayList<>();

	private List<String> createStringAuth() {
		List<String> list = new ArrayList<>();
		for (Authority r : authorityEntity)
			list.add(r.getAuthority());
		return list;
	}

	@JsonIgnore
	public List<String> getAuthorityList() {
		return createStringAuth();
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return createStringAuth().stream().map(SimpleGrantedAuthority::new).collect(toList());
	}
	
	public String getRefreshToken()
	{
		if (refreshToken != null) return refreshToken.getRefreshToken();
		
		return null;
	}

	public void addScore(int points)
	{
		score += points;
	}

//	public Leaderboard getLeaderboard()
//	{
//		return game.getLeaderboard();
//	}

//	public boolean quitLobby()
//	{
//		if (lobby == null) return false;
//
//		if (lobby.quitLobby(this))
//		{
//			lobby = null;
//			return true;
//		}
//
//		return false;
//	}
//
//	public boolean createLobby()
//	{
//		if (lobby != null) return false;
//
//		game.createLobby(this);
//
//		if (lobby != null) return true;
//
//		return false;
//	}
//
//	public boolean joinLobby(int idLobby)
//	{
//		if (lobby != null) return false;
//
//		if (idLobby <= -1) lobby = game.joinPublicLobby(this);
//		else lobby = game.joinPrivateLobby(this, idLobby);
//
//		if (lobby != null) return true;
//
//		return false;
//	}
//


	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", score=" + score +
				", token='" + token + '\'' +
				", refreshToken=" + refreshToken +
				", online=" + online +
				", lobby=" + lobby +
				", sessionId='" + sessionId + '\'' +
				", authorityEntity=" + authorityEntity +
				'}';
	}
}
