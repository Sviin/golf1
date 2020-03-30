package com.golf.golf1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.golf.golf1.domain.Course;
import com.golf.golf1.domain.CourseRepository;
import com.golf.golf1.domain.Round;
import com.golf.golf1.domain.RoundRepository;
import com.golf.golf1.domain.User;
import com.golf.golf1.domain.UserRepository;

@SpringBootApplication
public class GolfApplication {
	private static final Logger log = LoggerFactory.getLogger(GolfApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GolfApplication.class, args);
	}
	@Bean
	public CommandLineRunner roundDemo(RoundRepository repository, CourseRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save corses to H2-database");
			crepository.save(new Course("Golf Talma Master", 72));
			crepository.save(new Course("Golf Talma Laakso", 72));
			crepository.save(new Course("Vuosaari", 72));
			
			repository.save(new Round(72, 32, 14, 10, crepository.findByName("Golf Talma Master").get(0)));
			repository.save(new Round(71, 29, 13, 9,  crepository.findByName("Golf Talma Laakso").get(0)));	
			
			// Create users: admin/admin user/user
			User user1 = new User("Joonas","Huttunen", "user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("Joonas","Huttunen","admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all rounds");
			for (Round round : repository.findAll()) {
				log.info(round.toString());
			}

		};
	}
}
