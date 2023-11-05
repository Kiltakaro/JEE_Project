package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReviewController {

    private ReviewRepository reviewRepository;
    private AnimeRepository animeRepository;

    @Autowired
    public ReviewController(ReviewRepository reviewRepository,AnimeRepository animeRepository) {
        this.reviewRepository = reviewRepository;
        this.animeRepository = animeRepository;
    }

    @GetMapping("/review")
    public String showReview(@RequestParam Long animeId,Model model) {
        return "review";
    }

    @PostMapping("/review")
    public String addReview(@RequestParam("note") int note, @RequestParam("critique") String texte, @RequestParam("animeId") Long animeId){
        Review review = new Review();
        review.setRating(note);
        review.setReview(texte);
        review.setAnime(animeRepository.findById(animeId).orElse(null));
        review.setDate(String.valueOf(new java.sql.Date(System.currentTimeMillis())));
        reviewRepository.save(review);
        return "redirect:animePage?animeId="+animeId;
    }
}
