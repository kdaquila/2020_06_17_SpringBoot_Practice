package com.kdaquila.site;

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

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUsername("user");
		user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("pass"));
		user.setRole("ROLE_ADMIN");
		user.setEmail("user@example.com");
		user.setAccountExpired(false);
		user.setAccountLocked(false);
		user.setCredentialsExpired(false);
		user.setEnabled(true);
		userRepository.save(user);
	}
}
