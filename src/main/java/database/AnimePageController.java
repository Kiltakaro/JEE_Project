package database;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimePageController {
    @GetMapping("/AnimePage")
    public String Accueil(Model model) {
        return "AnimePage";
    }
}