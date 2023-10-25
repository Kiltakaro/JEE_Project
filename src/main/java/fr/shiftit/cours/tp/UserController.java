package fr.shiftit.cours.tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession session;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registration"; 
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password); // Note: Insecure for production

        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsername(username);       
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user); // MET EN PLACE LA SESSION
            return "redirect:/afficheTest"; 
        } else {
            return "redirect:/login?error"; 
        }
    }
}

