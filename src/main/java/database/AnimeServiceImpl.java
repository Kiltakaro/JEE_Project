package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeServiceImpl implements AnimeService {

    private final AnimeRepository animeRepository;

    @Autowired
    public AnimeServiceImpl(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @Override
    public void save(Anime anime) {
        animeRepository.save(anime);
    }

    @Override
    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    @Override
    public Anime getAnimeById(Long id) {
        return animeRepository.findById(id).orElse(null);
    }

    @Override
    public void updateAnime(Anime editedAnime) {
        Anime existingAnime = animeRepository.findById(editedAnime.getId()).orElse(null);

        if (existingAnime != null) {
            // Update the properties of the existing anime with the values from editedAnime
            existingAnime.setName(editedAnime.getName());
            existingAnime.setDescription(editedAnime.getDescription());
            // Update other properties as needed

            animeRepository.save(existingAnime); // Save the updated anime record
        }
    }
}
