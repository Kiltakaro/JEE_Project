package database;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Critic {


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
}
