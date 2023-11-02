package database;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnimeService {
    void save(Anime anime);
    List<Anime> findByName(String name);
    List<Anime> searchAnime(String name);
}