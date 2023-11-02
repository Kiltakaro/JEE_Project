package database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private AnimeRepository animeRepository;
    /*
    @GetMapping("/recherche")
    public String getSearch(@RequestParam String recherche, Model model) {
        List<Anime> anime = animeRepository.findByName(recherche);
        model.addAttribute("results", anime);
        return "recherche";
    }*/
}
