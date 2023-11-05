package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AnimeController {

    final AnimeService animeService;
    @Autowired
    private AnimeRepository animeRepository;

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
  
    @GetMapping("/recherche")
    public String searchAnime(@RequestParam String name,Model model){
        List<Anime> animeSuggestions = animeService.searchAnime(name);
        model.addAttribute("results", animeSuggestions);
        return "recherche";
    }

   
    @PostMapping("/edit-anime")
    public String updateAnime(@ModelAttribute Anime editedAnime) {
        animeService.updateAnime(editedAnime);
        return "redirect:/AnimePage?animeId=" + editedAnime.getId();
    }
    
    @GetMapping("/edit-anime/{animeId}")
    public String showEditForm(@PathVariable Long animeId, Model model) {
        Anime anime = animeService.getAnimeById(animeId);
        if (anime != null) {
            model.addAttribute("anime", anime);
            return "edit-anime-form"; // Return the edit form template
        } else {
            // Handle the case where the anime with the given ID is not found
            return "redirect:/error"; // You can create an error page
        }
    }


}
