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
public class TagController {
    @Autowired
    private AnimeRepository animeRepository;
    private TagRepository tagRepository;
    public TagController(AnimeRepository animeRepository, TagRepository tagRepository) {
        this.animeRepository = animeRepository;
        this.tagRepository = tagRepository;
    }
    @GetMapping("/categories")
    public String getRecentAnime(Model model) {
        List<Anime> films = animeRepository.findAll();
        films.sort(Comparator.comparing(Anime::getReleaseDate).reversed());
        List<Anime> recentAnimes = films.subList(0,films.size());
        model.addAttribute("recentAnimes", recentAnimes);
        return "categories";
    }
    @GetMapping("/addTag")
    public String addCategorie(Model model) {
        return "addTag";
    }
    @PostMapping("/addTag")
    public String addCategorie(@RequestParam String name, Model model) {
        Tag tag = new Tag();
        tag.setName(name);
        tagRepository.save(tag);
        return "redirect:/categories";
    }


}