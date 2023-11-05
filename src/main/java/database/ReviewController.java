package database;

import jakarta.servlet.http.HttpSession;
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
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private AnimeRepository animeRepository;
    @Autowired
    private HttpSession session;


    @Autowired
    public ReviewController(ReviewRepository reviewRepository,AnimeRepository animeRepository) {
        this.reviewRepository = reviewRepository;
        this.animeRepository = animeRepository;
    }
    @GetMapping("/review")
    public String showReview(@RequestParam Long animeId, Model model) {
        return "review";
    }

    @PostMapping("/review")
    public String addReview(@RequestParam("note") int note, @RequestParam("critique") String texte, @RequestParam("animeId") Long animeId) {
        double rating = note;
        User user = (User) session.getAttribute("user");
        Anime anime=animeRepository.findById(animeId).orElse(null);
        List<Review> reviews = reviewRepository.findByAnimeId(animeId);
        for (Review r : reviews) {
            rating +=r.getRating();
        }
        rating = rating/(reviews.size()+1);
        anime.setRating(rating);
        if (user != null) {
            Review review = new Review();
            review.setRating(note);
            review.setReview(texte);
            review.setAnime(anime);
            review.setDate(String.valueOf(new java.sql.Date(System.currentTimeMillis())));
            review.setUser(user);
            reviewRepository.save(review);
            return "redirect:animePage?animeId=" + animeId;
        } else {
            return "redirect:/login?error";
        }
    }
}
