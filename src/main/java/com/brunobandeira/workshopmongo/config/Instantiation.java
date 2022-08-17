package com.brunobandeira.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.brunobandeira.workshopmongo.domain.Post;
import com.brunobandeira.workshopmongo.domain.User;
import com.brunobandeira.workshopmongo.dto.AuthorDTO;
import com.brunobandeira.workshopmongo.repository.PostRepository;
import com.brunobandeira.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		repo.deleteAll();
		postRepo.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		repo.saveAll(Arrays.asList(maria,alex,bob));
 
		Post post = new Post(null,sdf.parse("12/12/2022"),"Partiu Viagem!","Vou viajar para são paulo, Abraços", new AuthorDTO(maria));
		Post post1 = new Post(null,sdf.parse("13/08/2022"),"Bom dia!","Acordei feliz hoje!",new AuthorDTO(maria));

		postRepo.saveAll(Arrays.asList(post,post1));
		
		maria.getPost().addAll(Arrays.asList(post,post1));
		repo.save(maria);
	}

	
}
