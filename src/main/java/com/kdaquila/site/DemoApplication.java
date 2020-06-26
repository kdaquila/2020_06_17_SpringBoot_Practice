package com.kdaquila.site;

import com.kdaquila.site.models.Movie;
import com.kdaquila.site.models.MovieRepository;
import com.kdaquila.site.models.User;
import com.kdaquila.site.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createSampleUsers();
		createSampleMovies();
	}

	public void createSampleUsers() {
		User user1 = new User();
		user1.setUsername("user");
		user1.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("pass"));
		user1.setRole("ROLE_ADMIN");
		user1.setEmail("user@example.com");
		user1.setAccountExpired(false);
		user1.setAccountLocked(false);
		user1.setCredentialsExpired(false);
		user1.setEnabled(true);
		userRepository.save(user1);

		User user2 = new User();
		user2.setUsername("user2");
		user2.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("pass2"));
		user2.setRole("ROLE_ADMIN");
		user2.setEmail("user2@example.com");
		user2.setAccountExpired(false);
		user2.setAccountLocked(false);
		user2.setCredentialsExpired(false);
		user2.setEnabled(true);
		userRepository.save(user2);
	}

	public void createSampleMovies() {
		Movie movie1 = new Movie();
		movie1.setTitle("Gone With The Wind");
		movie1.setYear(1940);
		movie1.setBestQuote("Frankly, my dea, I don't give a damn.");
		movie1.setDescription("");
		movieRepository.save(movie1);

		Movie movie2 = new Movie();
		movie2.setTitle("The Godfather");
		movie2.setYear(1972);
		movie2.setBestQuote("I'm gonna make him an offer he can't refuse.");
		movie2.setDescription("");
		movieRepository.save(movie2);
	}
}
