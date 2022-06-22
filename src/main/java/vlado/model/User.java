package vlado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class User {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@Email(message = "Korisnicko ime mora biti email adresa.")
	private String username;
	@Column
	@NotBlank(message = "Password mora biti unet.")
	private String password;
	@Column
	private boolean enable;
	
	public User() {
	}

	public User(@Email(message = "Korisnicko ime mora biti email adresa.") String username,
			@NotBlank(message = "Password mora biti unet.") String password, boolean enable) {
		this.username = username;
		this.password = password;
		this.enable = enable;
	}

	public User(Long id, @Email(message = "Korisnicko ime mora biti email adresa.") String username,
			@NotBlank(message = "Password mora biti unet.") String password, boolean enable) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.enable = enable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
