package database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class AnimePageController {
    @Autowired
    private AnimeRepository animeRepository;
    @GetMapping("/AnimePage")
    public String getAnimePage(@RequestParam Long animeId, Model model) {
        Anime anime = animeRepository.findById(animeId).orElse(null);
        if (anime != null) {
            model.addAttribute("anime", anime);
            List<Review> reviews = anime.getReviews();
            //reviews.sort(Comparator.comparing(Review::getDate).reversed());
            model.addAttribute("reviews", reviews);
        }
        return "AnimePage";
    }
}