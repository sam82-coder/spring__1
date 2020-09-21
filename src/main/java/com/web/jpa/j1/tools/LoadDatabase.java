package com.web.jpa.j1.tools;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.web.jpa.j1.domain.User;
import com.web.jpa.j1.repositories.UserRepositories;

@Configuration
@Slf4j
public class LoadDatabase {
	


	@Bean
	CommandLineRunner initDatabase(UserRepositories repository) {
		
		
		return args ->{
			log.info("Preloading  "+ repository.save(new User("Billbo","**##*")));
			log.info("Preloading  "+ repository.save(new User("Frodo","**^^^*")));
		};
	}
	
	
}
