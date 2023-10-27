package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class AccueilController {
    @Autowired
    private AnimeRepository animeRepository;
    @GetMapping("/Accueil")
    public String getRecentAnime(Model model) {
        int n = 7;
        List<Anime> films = animeRepository.findAll();
        List<Anime> copyOfFilms = new ArrayList<>(films);
        films.sort(Comparator.comparing(Anime::getReleaseDate).reversed());
        List<Anime> recentAnimes = films.subList(0, Math.min(n, copyOfFilms.size()));
        copyOfFilms.sort(Comparator.comparing(Anime::getRating).reversed());
        List<Anime> topRatedAnimes = copyOfFilms.subList(0, Math.min(n, copyOfFilms.size()));
        model.addAttribute("recentAnimes", recentAnimes);
        model.addAttribute("topRatedAnimes", topRatedAnimes);

        return "Accueil";
    }


}