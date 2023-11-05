package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class TagController {
    @Autowired
    private AnimeRepository animeRepository;
    private TagRepository tagRepository;
    public TagController(AnimeRepository animeRepository, TagRepository tagRepository) {
        this.animeRepository = animeRepository;
        this.tagRepository = tagRepository;
    }
    @GetMapping("/categories/{tagId}")
    public String getRecentAnime(@PathVariable Long tagId, Model model) {
        List<Tag> tags = tagRepository.findAll();
        model.addAttribute("tags", tags);
        Set<Anime> filteredAnimes = new HashSet<>();
        if (tagId!= null) {
            Tag selectedCategory = tagRepository.findById(tagId).orElse(null);
            if (selectedCategory != null) {
                model.addAttribute("recentAnimes", selectedCategory.getAnimes());
            }
        } else {
            model.addAttribute("recentAnimes", animeRepository.findAll());
        }
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
    @PostMapping("/catégorie")
    public String addCatégorieAnime(@RequestParam("catégorie") Long tagId, @RequestParam("animeId") Long animeId) {
        Anime anime=animeRepository.findById(animeId).orElse(null);
        Tag tag =tagRepository.findById(tagId).orElse(null);
        anime.getTags().add(tag);
        animeRepository.save(anime);
        return "redirect:animePage?animeId=" + animeId;
    }


}