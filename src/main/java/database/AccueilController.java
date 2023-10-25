package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccueilController {
    @Autowired
    private FilmRepository filmRepository;
    @GetMapping("/Accueil")
    public String Accueil(Model model) {
        List<Film> films = filmRepository.findAll();

        model.addAttribute("films", films);

        return "Accueil";
    }
}