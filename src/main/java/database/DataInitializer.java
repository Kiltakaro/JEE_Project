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
    
    @Autowired
    private CharacterRepository characterRepository;
    

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
        anime1.setDescription("Il y a 107 ans, les Titans ont presque exterminé la race humaine.\\n\"\n"
        		+ "        		+ \"Ces Titans mesurent principalement une dizaine de mètres et ils se nourrissent d'humains.\\n\"\n"
        		+ "        		+ \"Les humains ayant survécus à cette extermination ont construit une cité fortifiée avec des murs d'enceinte de 50 mètres de haut pour pouvoir se protéger des Titans.\\n\"\n"
        		+ "        		+ \"\\n\"\n"
        		+ "        		+ \"Pendant 100 ans les humains ont connu la paix.\\n\"\n"
        		+ "        		+ \"Eren est un jeune garçon qui rêve de sortir de la ville pour explorer le monde extérieur.\\n\"\n"
        		+ "        		+ \"Il mène une vie paisible avec ses parents et sa sœur Mikasa dans le district de Shiganshina.\\n\"\n"
        		+ "        		+ \"\\n\"\n"
        		+ "        		+ \"Mais un jour de l'année 845, un Titan de plus de 60 mètres de haut apparaît. Il démolit une partie du mur du district de Shiganshina et provoque une invasion de Titans.\\n\"\n"
        		+ "        		+ \"\\n\"\n"
        		+ "        		+ \"Eren verra sa mère se faire dévorer sous ses yeux sans rien pouvoir faire. Il décidera après ces événements traumatisants de s'engager dans les forces militaires de la ville avec pour but d'exterminer tous les Titans qui existent.");
        anime1.setRating(5);
        anime1.setSeasons(4);
        anime1.setImageURL("https://fr.web.img6.acsta.net/pictures/20/12/28/10/24/5603983.jpg");
        anime1.setReleaseDate("2014-01-01");
        anime1.setStudio("MAPPA");
        
        Character charSNK1 = new Character();
        
        
        
        Anime anime2 = new Anime();
        anime2.setName("86 - Eighty-six");
        anime2.setDescription("Basé sur le roman 86 de Asato Asato.\n"
        		+ "\n"
        		+ "La République de San Magnolia est un vaste territoire constitué de 85 districts. Constamment attaqué par un Empire voisin et ses mystérieuses armes baptisées \"Legion\", la République a décidé de contre-attaquer et est finalement parvenue à repousser la menace grâce au développement d'armes similaires. C'est du moins ainsi que sont officiellement présentées les choses.\n"
        		+ "\n"
        		+ "Officiellement, le 86è district n'existe pas. Pourtant, c'est grâce aux combattants qui s'y trouvent, parmi lesquels l'escadron Spearhead, dirigé par Shin et commandé par Lena, que la République a retrouvé un semblant de paix.\n"
        		+ "\n"
        		+ "");
        anime2.setRating(9);
        anime2.setSeasons(1);
        anime2.setImageURL("https://fr.web.img6.acsta.net/pictures/21/04/06/18/19/5235708.jpg");
        anime2.setReleaseDate("2020-01-01");
        anime2.setStudio("A-1 Picture");
        
        Anime anime3 = new Anime();
        anime3.setName("Full Metal Alchemist");
        anime3.setDescription("À Amestris, un immense pays, l'armée tient une place très importante puisque son dirigeant, King Bradley, est également le président du pays. Cette armée est soutenue par des alchimistes, les Alchimistes d'État dont le plus jeune, Edward Elric, a pour spécialité le métal. On le surnomme le Fullmetal Alchemist.\n"
        		+ "\n"
        		+ "Edward a tout juste 15 ans, et parcourt le pays en compagnie de son frère, Alphonse, à la recherche de la Pierre Philosophale. Il a pour but de rendre son corps à son frère, car Alphonse n'est qu'une âme rattaché à une armure par un sceau de sang. Étant plus jeunes, ils ont essayé de redonner vie à leur mère grâce à l'alchimie, mais la tentative fut un échec cuisant, et Alphonse perdit son corps.\n"
        		+ "Edward garde lui aussi des séquelles de leur tentative, puisqu'il a le bras droit et la jambe gauche en métal. Mais la quête des deux frères risque de les mener vers une vérité plus terrible qu'ils ne l'imaginaient.");
        anime3.setRating(9);
        anime3.setSeasons(1);
        anime3.setImageURL("https://fr.web.img3.acsta.net/pictures/19/07/29/15/56/5220959.jpg");
        anime3.setReleaseDate("2009-05-04");
        anime3.setStudio("Bones");
        
        Anime anime4 = new Anime();
        anime4.setName("One piece");
        anime4.setDescription("Il fut un temps où Gold Roger était le plus grand de tous les pirates, le \"Roi des Pirates\" était son surnom. A sa mort, son trésor d'une valeur inestimable connu sous le nom de \"One Piece\" fut caché quelque part sur \"Grand Line\". De nombreux pirates sont partis à la recherche de ce trésor mais tous sont morts avant même de l'atteindre. Monkey D. Luffy rêve de retrouver ce trésor légendaire et de devenir le nouveau \"Roi des Pirates\". Après avoir mangé un fruit du démon, il possède un pouvoir lui permettant de réaliser son rêve. Il lui faut maintenant trouver un équipage pour partir à l'aventure !");
        anime4.setRating(8);
        anime4.setSeasons(1);
        anime4.setImageURL("https://www.nautiljon.com/images/anime/00/60/mini/one_piece_6.webp?11698616500");
        anime4.setReleaseDate("1999-06-09");
        anime4.setStudio("TOEI");
        
        Anime anime5 = new Anime();
        anime5.setName("Dororo");
        anime5.setDescription("Adaptation en série TV animée du manga Dororo de Osamu Tezuka.\n"
        		+ "\n"
        		+ "Hyakkimaru est infirme : 48 parties de son corps ont été vendues à autant de démons avant sa naissance. Rafistolé par un chirurgien compatissant, adolescent, il se découvre d'étranges pouvoirs psychiques. Accompagné de Dororo, un petit voleur espiègle, il arpente le Japon à la recherche d'un endroit où vivre en paix... affrontant au passage esprits et forces obscures.\n"
        		+ "\n"
        		+ "");
        anime5.setRating(7);
        anime5.setSeasons(1);
        anime5.setImageURL("https://www.nautiljon.com/images/anime/00/67/mini/dororo_7676.webp?11696270137");
        anime5.setReleaseDate("2019-01-07");
        anime5.setStudio("MAPPA");
        
        animeRepository.save(anime1);
        animeRepository.save(anime2);
        animeRepository.save(anime3);
        animeRepository.save(anime4);
        animeRepository.save(anime5);

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

