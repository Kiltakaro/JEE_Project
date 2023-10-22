package database;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;


@Entity
public class Character {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String voiceActor;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVoiceActor(String voiceActor) {
        this.voiceActor = voiceActor;
    }
}