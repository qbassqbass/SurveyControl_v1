/**
 * 
 */
package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Jakub
 *
 */
@Entity
@Table(name = "user")
public class User {
	
	@Id
	private String id;
	
	@NotNull
	private String fullName;
	
	@NotNull
	private String email;
	
	@NotNull
	private String username;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

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

	public User(){
		
	}
	
	public User(String id){
		this.id = id;
	}
	
	public User(String id, String fullName, String email, String username){
		this(id);
		this.fullName = fullName;
		this.email = email;
		this.username = username;
	}

}
