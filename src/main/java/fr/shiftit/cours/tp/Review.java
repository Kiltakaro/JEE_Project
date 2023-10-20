package fr.shiftit.cours.tp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    //@OneToOne
    //private User user;
}



