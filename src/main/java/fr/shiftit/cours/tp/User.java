package fr.shiftit.cours.tp;
import lombok.Getter;
@Entity
public class User {

    @Id @GeneratedValue
    private Long id;
    @Getter
    private String username;
    @Getter
    private String password;
}
