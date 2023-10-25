package fr.shiftit.cours.tp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class RoleController {

    @GetMapping("/admin")
    public String adminDashboard(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null && "admin".equals(user.getRole())) {
            return "admin-dashboard";         } else {
            return "access-denied";
        }
    }

    @GetMapping("/user")
    public String userDashboard(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null && "user".equals(user.getRole())) {
            return "user-dashboard"; 
        } else {
            return "access-denied";
        }
    }

    // Other methods and logic for different roles

    // ...
}
