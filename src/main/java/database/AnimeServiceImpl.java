package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

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
    public List<Anime> searchAnime(String name) {
        return animeRepository.searchAnime(name);
    }

    @Override
    public Anime getAnimeById(Long id) {
        return animeRepository.findById(id).orElse(null);
    }

    @Override
    public void updateAnime(Anime editedAnime) {
        Anime existingAnime = animeRepository.findById(editedAnime.getId()).orElse(null);

        if (existingAnime != null) {
            existingAnime.setName(editedAnime.getName());
            existingAnime.setDescription(editedAnime.getDescription());
            existingAnime.setSeasons(editedAnime.getSeasons());
            existingAnime.setImageURL(editedAnime.getImageURL());
            existingAnime.setStudio(editedAnime.getStudio());
            existingAnime.setReleaseDate(editedAnime.getReleaseDate());

            animeRepository.save(existingAnime);
        }
    }
    
    
    @Override
    public void deleteAnime(Long id) {
        animeRepository.deleteById(id);
    }

    
}
