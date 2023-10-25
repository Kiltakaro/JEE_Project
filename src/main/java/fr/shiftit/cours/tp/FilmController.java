package fr.shiftit.cours.tp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FilmController {

	@Autowired
	DirectorRepository directorRepo;
	
	@Autowired
	FilmRepository filmrepo;
	
	@GetMapping("/addFilm")
	public String listFilms(Model model) {
		
		List<Director> directors = directorRepo.findAll();
		model.addAttribute("directors",directors);
		
		return "addFilm";
	}
	

	@PostMapping("/addFilm")
	public String addFilm(String title,Long directorId, String imageURL) {
		System.out.println("title:"+title);
		System.out.println("id:"+directorId);
		System.out.println("URL:"+imageURL);
		Optional<Director> director = directorRepo.findById(directorId);
		if(director.isEmpty()) {
			System.out.println("director not found");
			throw new RuntimeException("director not found");
		}
		Film film = new Film();
		film.setTitle(title);
	    film.setImageURL(imageURL); 
		film.setDirector(director.get());
		filmrepo.save(film);
		
		return "redirect:/addFilm";
	}
}
