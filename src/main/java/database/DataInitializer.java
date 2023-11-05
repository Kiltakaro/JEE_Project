package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.util.List;
import java.util.Random;

@Component
public class DataInitializer {

    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @PostConstruct
    public void initData() {
        long animeCount = animeRepository.count();
        long userCount = userRepository.count();
        long reviewCount = reviewRepository.count();
        if (animeCount == 0) {
            initializeDatabaseWithDefaultAnime();
        }

        if (userCount == 0) {
            initializeDatabaseWithDefaultUsers();
        }
        if (reviewCount == 0) {
            initializeDatabaseWithDefaultReviews();
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
        anime1.setSeasons(4);
        anime1.setImageURL("https://fr.web.img6.acsta.net/pictures/20/12/28/10/24/5603983.jpg");
        anime1.setReleaseDate("2014-01-01");
        anime1.setStudio("MAPPA");
        
        Character charSNK1 = new Character();
        charSNK1.setName("Eren");
        charSNK1.setImageURL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUyr5G2swRuHq32MPPUF4fXSGJF4OFGqjBDw&usqp=CAU");        
        charSNK1.setAnime(anime1);

        Character charSNK2 = new Character();
        charSNK2.setName("Mikasa");
        charSNK2.setImageURL("https://i.pinimg.com/1200x/88/72/5d/88725dc10803e09af4bb9ce91d4c5f24.jpg");  
        charSNK2.setAnime(anime1);
        
        
        Anime anime2 = new Anime();
        anime2.setName("86 - Eighty-six");
        anime2.setDescription("Basé sur le roman 86 de Asato Asato.\n"
        		+ "\n"
        		+ "La République de San Magnolia est un vaste territoire constitué de 85 districts. Constamment attaqué par un Empire voisin et ses mystérieuses armes baptisées \"Legion\", la République a décidé de contre-attaquer et est finalement parvenue à repousser la menace grâce au développement d'armes similaires. C'est du moins ainsi que sont officiellement présentées les choses.\n"
        		+ "\n"
        		+ "Officiellement, le 86è district n'existe pas. Pourtant, c'est grâce aux combattants qui s'y trouvent, parmi lesquels l'escadron Spearhead, dirigé par Shin et commandé par Lena, que la République a retrouvé un semblant de paix.\n"
        		+ "\n"
        		+ "");
        anime2.setSeasons(1);
        anime2.setImageURL("https://fr.web.img6.acsta.net/pictures/21/04/06/18/19/5235708.jpg");
        anime2.setReleaseDate("2020-01-01");
        anime2.setStudio("A-1 Picture");
        
        Character char861 = new Character();
        char861.setName("Handler-1");
        char861.setImageURL("https://upload.wikimedia.org/wikipedia/en/f/fb/86_BD_vol._1.jpg");  
        char861.setAnime(anime2);

        Character char862 = new Character();
        char862.setName("Shinei Nouzen");
        char862.setImageURL("https://static.zerochan.net/Shinei.Nouzen.full.3290091.jpg");  
        char862.setAnime(anime2);
        
        Anime anime3 = new Anime();
        anime3.setName("Full Metal Alchemist");
        anime3.setDescription("À Amestris, un immense pays, l'armée tient une place très importante puisque son dirigeant, King Bradley, est également le président du pays. Cette armée est soutenue par des alchimistes, les Alchimistes d'État dont le plus jeune, Edward Elric, a pour spécialité le métal. On le surnomme le Fullmetal Alchemist.\n"
        		+ "\n"
        		+ "Edward a tout juste 15 ans, et parcourt le pays en compagnie de son frère, Alphonse, à la recherche de la Pierre Philosophale. Il a pour but de rendre son corps à son frère, car Alphonse n'est qu'une âme rattaché à une armure par un sceau de sang. Étant plus jeunes, ils ont essayé de redonner vie à leur mère grâce à l'alchimie, mais la tentative fut un échec cuisant, et Alphonse perdit son corps.\n"
        		+ "Edward garde lui aussi des séquelles de leur tentative, puisqu'il a le bras droit et la jambe gauche en métal. Mais la quête des deux frères risque de les mener vers une vérité plus terrible qu'ils ne l'imaginaient.");
        anime3.setSeasons(1);
        anime3.setImageURL("https://fr.web.img3.acsta.net/pictures/19/07/29/15/56/5220959.jpg");
        anime3.setReleaseDate("2009-05-04");
        anime3.setStudio("Bones");
        
        Character charFMAB1 = new Character();
        charFMAB1.setName("Edward Elric");
        charFMAB1.setImageURL("https://i.pinimg.com/736x/a1/29/61/a12961c9d22d7f8a0363f7d99ceccc52.jpg");  
        charFMAB1.setAnime(anime3);

        Character charFMAB2 = new Character();
        charFMAB2.setName("Alphonse Elric");
        charFMAB2.setImageURL("https://cloudfront.first4figures.com/media/wysiwyg/Anime/Hiromu_Arakawa/FMA_Brotherhood/FMAB_Al_1_1279x720px.png");  
        charFMAB2.setAnime(anime3);
        
        Anime anime4 = new Anime();
        anime4.setName("One piece");
        anime4.setDescription("Il fut un temps où Gold Roger était le plus grand de tous les pirates, le \"Roi des Pirates\" était son surnom. A sa mort, son trésor d'une valeur inestimable connu sous le nom de \"One Piece\" fut caché quelque part sur \"Grand Line\". De nombreux pirates sont partis à la recherche de ce trésor mais tous sont morts avant même de l'atteindre. Monkey D. Luffy rêve de retrouver ce trésor légendaire et de devenir le nouveau \"Roi des Pirates\". Après avoir mangé un fruit du démon, il possède un pouvoir lui permettant de réaliser son rêve. Il lui faut maintenant trouver un équipage pour partir à l'aventure !");
        anime4.setSeasons(1);
        anime4.setImageURL("https://www.nautiljon.com/images/anime/00/60/mini/one_piece_6.webp?11698616500");
        anime4.setReleaseDate("1999-06-09");
        anime4.setStudio("TOEI");
        
        Character charOP1 = new Character();
        charOP1.setName("Luffy");
        charOP1.setImageURL("https://www.dvdtalk.com/reviews/images/reviews/275/1324586843_2.png");  
        charOP1.setAnime(anime4);

        Character charOP2 = new Character();
        charOP2.setName("Nami");
        charOP2.setImageURL("https://www.nautiljon.com/images/perso/00/82/nami_28.webp");
        charOP2.setAnime(anime4);

        Character charOP3 = new Character();
        charOP3.setName("Zoro");
        charOP3.setImageURL("https://i.ytimg.com/vi/IQFHCuH-I7c/hqdefault.jpg");  
        charOP3.setAnime(anime4);
        
        Anime anime5 = new Anime();
        anime5.setName("Dororo");
        anime5.setDescription("Adaptation en série TV animée du manga Dororo de Osamu Tezuka.\n"
        		+ "\n"
        		+ "Hyakkimaru est infirme : 48 parties de son corps ont été vendues à autant de démons avant sa naissance. Rafistolé par un chirurgien compatissant, adolescent, il se découvre d'étranges pouvoirs psychiques. Accompagné de Dororo, un petit voleur espiègle, il arpente le Japon à la recherche d'un endroit où vivre en paix... affrontant au passage esprits et forces obscures.\n"
        		+ "\n"
        		+ "");
        anime5.setSeasons(1);
        anime5.setImageURL("https://www.nautiljon.com/images/anime/00/67/mini/dororo_7676.webp?11696270137");
        anime5.setReleaseDate("2019-01-07");
        anime5.setStudio("MAPPA");
        
        Character charDO1 = new Character();
        charDO1.setName("Dororo");
        charDO1.setImageURL("https://www.nautiljon.com/images/perso/00/75/dororo_17957.webp");  
        charDO1.setAnime(anime5);

        Character charDO2 = new Character();
        charDO2.setName("Hyakkimaru");
        charDO2.setImageURL("https://www.nautiljon.com/images/perso/00/65/hyakkimaru_17956.webp");  
        charDO2.setAnime(anime5);


        animeRepository.save(anime1);
        characterRepository.save(charSNK1);
        characterRepository.save(charSNK2);

        animeRepository.save(anime2);
        characterRepository.save(char861);
        characterRepository.save(char862);

        animeRepository.save(anime3);
        characterRepository.save(charFMAB1);
        characterRepository.save(charFMAB2);

        animeRepository.save(anime4);
        characterRepository.save(charOP1);
        characterRepository.save(charOP2);
        characterRepository.save(charOP3);

        animeRepository.save(anime5);
        characterRepository.save(charDO1);
        characterRepository.save(charDO2);

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
    private void initializeDatabaseWithDefaultReviews() {
        List<Anime> animes =animeRepository.findAll();
        List<User> users= userRepository.findAll();
        Random random = new Random();

        for (Anime anime : animes) {
            double totalRating = 0;
            int numberOfReviews = 0;
            for (User user : users) {
                Review review = new Review();
                review.setUser(user);
                review.setAnime(anime);
                int randomRating = random.nextInt(10) + 1;
                review.setRating(randomRating);
                totalRating += randomRating;
                numberOfReviews++;
                review.setReview("Avis aléatoire pour " + anime.getName());
                review.setDate("2021-05-01");
                reviewRepository.save(review);
            }
            double averageRating = totalRating / numberOfReviews;
            anime.setRating(averageRating);
            animeRepository.save(anime);
        }
    }
}

