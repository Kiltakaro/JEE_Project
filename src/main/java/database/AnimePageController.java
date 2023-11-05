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
    
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private TagRepository tagRepository;
    @GetMapping("/animePage")
    public String getAnimePage(@RequestParam Long animeId, Model model) {
        Anime anime = animeRepository.findById(animeId).orElse(null);
        if (animeId != null) {
            model.addAttribute("anime", anime);

            List<Character> characters = characterRepository.findByAnimeId(animeId);
            model.addAttribute("characters", characters);

            List<Review> reviews = anime.getReviews();
            //reviews.sort(Comparator.comparing(Review::getDate).reversed());
            model.addAttribute("reviews", reviews);
            List<Anime> animes =animeRepository.findAll();
            animes.sort(Comparator.comparing(Anime::getRating).reversed());
            int rank = animes.indexOf(anime) + 1;
            model.addAttribute("rank", rank);
            List<Tag> tags = tagRepository.findAll();
            model.addAttribute("tags", tags);
        }
        return "animePage";
    }
}