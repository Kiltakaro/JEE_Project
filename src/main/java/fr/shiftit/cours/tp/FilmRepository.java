package fr.shiftit.cours.tp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{
	
	List<Film> findByTitle(String title);
}
