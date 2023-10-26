package database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AfficheTestController {

    @Autowired
    private AnimeRepository animeRepository; // Supposons que vous avez un FilmRepository

    @GetMapping("/afficheTest")
    public String afficheTousLesFilms(Model model) {
        List<Anime> films = animeRepository.findAll();

        model.addAttribute("films", films);

        return "afficheTest";
    }
}

