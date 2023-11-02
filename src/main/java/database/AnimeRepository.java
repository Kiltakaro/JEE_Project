package database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long>{

    List<Anime> findByName(String lastName);
    @Query("SELECT a FROM Anime a WHERE UPPER(a.name) LIKE UPPER(CONCAT('%',:name,'%'))")
    public List<Anime> searchAnime(String name);

}
