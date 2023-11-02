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
    @GetMapping("/anime/search")
    public ResponseEntity<List<Anime>> searchAnime(@RequestParam String name,Model model){
        List<Anime> animeSuggestions = animeService.findByName(name);
        model.addAttribute("test", animeSuggestions);
        return ResponseEntity.ok(animeSuggestions);
    }
    /*
    @PostMapping("/recherche")
    public String searchAnime(@ModelAttribute("anime") Anime anime) {
        return "redirect:/recherche";
    }
    @GetMapping("/recherche")
    public String showAnimeSearch(@RequestParam String name,Model model) {
        List<Anime> animeSearched = animeService.findByName(name);
        model.addAttribute("results", animeSearched);
        return "recherche";
    }*/

}
