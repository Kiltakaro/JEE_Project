package fr.shiftit.cours.tp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User,Integer> {
    public User findUserByName(String username);
}