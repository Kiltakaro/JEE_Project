package database;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class User {

    @Id @GeneratedValue
    private Long id;

    // username
    private String username;

    // password
    @Column(name = "password")
    private String encryptedPassword;


    // email
    private String email;

    // Type of user
    private String type;


}
