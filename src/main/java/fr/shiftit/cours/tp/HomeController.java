package fr.shiftit.cours.tp;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String home(@AuthenticationPrincipal UserPrincipal principal, Model model){
        model.addAttribute("user",principal.getUser());
        return "userDetail";
    }
    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/logout-success")
    public String logout(){
        return "logout";
    }
}