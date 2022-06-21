package it.beije.turing.settemmezzo.login;

import java.io.Serializable;
import java.util.Objects;

/*Composite primary key, for UserAuthority, that uses two constructor , the method equals(Object obj), the method hashCode() 
  and implements the Serializable interface
*/	

public class UserAuthorityId implements Serializable {

	private static final long serialVersionUID = -1373585780629471712L;
	private Long userId;
	private Integer authorityId;
	
	//Constructor
	public UserAuthorityId (Long userId, Integer authorityId) {
		this.userId = userId;
		this.authorityId = authorityId;
	}

	//Constructor required from @IdClass in UserAuthority.
	public UserAuthorityId() {		}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof UserAuthorityId)) {return false;}

		UserAuthorityId id = (UserAuthorityId) obj;
		return this.userId.equals(id.userId) && this.authorityId.equals(id.authorityId);
	}
	
	public int hashCode() {
		return Objects.hash(userId, authorityId);
	}
}
