package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
