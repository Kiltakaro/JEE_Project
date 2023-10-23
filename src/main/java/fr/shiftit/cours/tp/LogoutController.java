package fr.shiftit.cours.tp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout() {
        // Ajoutez le code de déconnexion personnalisé ici si nécessaire
        return "redirect:/login";
    }
}
