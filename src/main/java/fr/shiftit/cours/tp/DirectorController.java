package fr.shiftit.cours.tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DirectorController {

	@Autowired
	DirectorRepository directorRepo;
	
	@GetMapping("/addDirector")
	public String showDirectorForm(Model model) {
		
		return "addDirector";
	}
	
	@PostMapping("/addDirector")
	public String addDirector(@ModelAttribute Director director) {

		System.out.println("dir:"+director);
		
		directorRepo.save(director);
		
		return "redirect:/addDirector";
	}
}
