package database;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_account") // Cannot use "user"
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String email;
	private String type;

	@OneToMany(mappedBy = "user")
	private List<Review> reviews = new ArrayList<>();
	
    public void setPassword(String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        this.password = hashedPassword;
    }

    public boolean verifyPassword(String inputPassword) {
        return BCrypt.checkpw(inputPassword, this.password);
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
	public String getType() {
		return type;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setType(String type) {
		this.type = type;
	}
}

