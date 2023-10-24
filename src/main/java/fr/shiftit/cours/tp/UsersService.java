package fr.shiftit.cours.tp;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
	
	@Service
	public class UsersService implements UserDetailsService {
	
	    @Autowired
	    UsersRepository usersRepository;
	    @Override
	    public UserDetails loadUserByUsername(String username) {
	        User user = usersRepository.findUserByName(username);
	        return new UserPrincipal(user);
	    }
	
	}