package database;

import jakarta.persistence.*;


@Entity
public class Review {


    @GeneratedValue @Id
    private Long id;

    // rating (1-10)
    private int rating;

    // review
    private String review;

    // title
    private String title;

    // date
    private String date;

    // One review is written by one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    // One review is written for one anime
    @ManyToOne
    @JoinColumn(name = "anime_id")
    private Anime anime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }
}
