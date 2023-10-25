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
}
