package it.beije.turing.settemmezzo.login;

import javax.persistence.*;

/*  That model uses two primary key, so for that reason we have to create a support Class ("UserAuthorityId"), to handle the id.
 *  That id will not be generated automatically, but must be set.
 */

@Entity
@IdClass(UserAuthorityId.class)
@Table(name = "user_authority")
public class UserAuthority {
	
	@Id
	@Column(name = "user_id")
	private Long userId;
	
	@Id
	@Column(name = "authority_id")
	private Integer authorityId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Integer getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

}
