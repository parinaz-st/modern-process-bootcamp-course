package com.modern.process;

import com.modern.process.domain.Post;
import com.modern.process.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}
	@Autowired
	private PostRepository postRepository;
	@Override
	public void run(String... args) throws Exception {
		Post post= new Post();
		post.setTitle("post_1");
		postRepository.save(post);
	}
}
