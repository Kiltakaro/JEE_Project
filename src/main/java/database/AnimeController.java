package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimeController {

    final AnimeService animeService;

    @Autowired
    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping("/anime/form")
    public String showAnimeForm(Model model) {
        model.addAttribute("anime", new Anime());
        return "anime-form";
    }

    @PostMapping("/anime/save")
    public String addAnime(@ModelAttribute("anime") Anime anime) {

        System.out.println("dir:"+anime);
        animeService.save(anime);

        return "redirect:/anime/form";
    }
}
