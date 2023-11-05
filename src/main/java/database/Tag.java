package database;


import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // One tag can be used for many animes
    @ManyToMany(mappedBy = "tags")
    private Set<Anime> animes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Anime> getAnimes() {
        return animes;
    }

    public void setAnimes(Set<Anime> animes) {
        this.animes = animes;
    }
}
