package database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> findByName(String name);
    List<Character> findByAnimeId(Long animeId);
}
