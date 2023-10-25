package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimeController {

    @Autowired
    AnimeRepository animeRepository;

    @GetMapping("/addAnime")
    public String showAnimeForm(Model model) {

        return "addAnime";
    }

    @PostMapping("/addAnime")
    public String addAnime(@ModelAttribute Anime anime) {

        System.out.println("dir:"+anime);
        animeRepository.save(anime);

        return "redirect:/addAnime";
    }
}
