package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initData() {
        long animeCount = animeRepository.count();
        long userCount = userRepository.count();

        if (animeCount == 0) {
            initializeDatabaseWithDefaultAnime();
        }

        if (userCount == 0) {
            initializeDatabaseWithDefaultUsers();
        }
    }
    	
    

    private void initializeDatabaseWithDefaultAnime() {
        Anime anime1 = new Anime();
        anime1.setName("SNK");
        anime1.setDescription("Put description");
        anime1.setRating(5);
        anime1.setImageURL("https://fr.web.img6.acsta.net/pictures/20/12/28/10/24/5603983.jpg");
        anime1.setReleaseDate("2014-01-01");
        anime1.setStudio("MAPPA");
        
        Anime anime2 = new Anime();
        anime2.setName("86 - Eighty-six");
        anime2.setDescription("Put description");
        anime2.setRating(9);
        anime2.setImageURL("https://fr.web.img6.acsta.net/pictures/21/04/06/18/19/5235708.jpg");
        anime2.setReleaseDate("2020-01-01");
        anime2.setStudio("A-1 Picture");
        
        Anime anime3 = new Anime();
        anime3.setName("Full Metal Alchemist Brotherwood");
        anime3.setDescription("Put description");
        anime3.setRating(9);
        anime3.setImageURL("https://fr.web.img3.acsta.net/pictures/19/07/29/15/56/5220959.jpg");
        anime3.setReleaseDate("2009-05-04");
        anime3.setStudio("Bones");
        
        animeRepository.save(anime1);
        animeRepository.save(anime2);
        animeRepository.save(anime3);
    }
 
    
    private void initializeDatabaseWithDefaultUsers() {
        User user1 = new User();
        user1.setUsername("admin");
        user1.setEmail("admin@example.com");
        user1.setPassword("admin"); 
        user1.setType("admin");

        User user2 = new User();
        user2.setUsername("user");
        user2.setEmail("user@example.com");
        user2.setPassword("user");
        user2.setType("user");

        userRepository.save(user1);
        userRepository.save(user2);
    }
}

