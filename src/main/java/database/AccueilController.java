<<<<<<< HEAD
package fr.shiftit.cours.tp;
=======
package database;
>>>>>>> main

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

<<<<<<< HEAD
@Controller
public class AccueilController {
    @GetMapping("/Accueil")
    public String Accueil(Model model) {
=======
import java.util.List;

@Controller
public class AccueilController {
    @Autowired
    private AnimeRepository animeRepository;
    @GetMapping("/Accueil")
    public String Accueil(Model model) {
        List<Anime> films = animeRepository.findAll();

        model.addAttribute("films", films);

>>>>>>> main
        return "Accueil";
    }
}