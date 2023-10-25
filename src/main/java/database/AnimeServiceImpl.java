package database;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AnimeServiceImpl implements AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    @Override
    public void save(Anime anime) {
        animeRepository.save(anime);
    }

    @Override
    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }
}
