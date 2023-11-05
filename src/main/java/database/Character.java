package database;


import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
public class Character {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String voiceActor;


    // a character belongs to one anime
    @ManyToOne
//    @JoinColumn(name = "anime_id")
    private Anime anime;

//    public Long getId() {
//        return id;
//    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getVoiceActor() {
//        return voiceActor;
//    }

    public void setVoiceActor(String voiceActor) {
        this.voiceActor = voiceActor;
    }

//    public Anime getAnime() {
//        return anime;
//    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }
}