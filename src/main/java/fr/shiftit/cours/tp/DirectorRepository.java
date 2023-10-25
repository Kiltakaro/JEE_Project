package fr.shiftit.cours.tp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long>{
	
	List<Director> findByLastName(String lastName);
}
