package com.modern.process;

import com.modern.process.domain.CommentType;
import com.modern.process.domain.Post;
import com.modern.process.domain.PostComment;
import com.modern.process.repository.PostCommentRepository;
import com.modern.process.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class BankApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private  PostCommentRepository postCommentRepository;
	@Override
	public void run(String... args) throws Exception {
//		Post post= new Post();
//		post.setTitle("post_1");
//		postRepository.save(post);
//
//		Post post2= new Post();
//		post2.setTitle("post_2");
//		postRepository.save(post2);
//		Post post3= new Post();
//		post3.setTitle("post_3");
//		postRepository.save(post3);
//
//		PostComment postComment = new PostComment();
//		postComment.setReview("goooood");
//		postComment.setComment_date(new Date());
////		postComment.setCode(11);
//		postComment.setType(CommentType.BAD);
//		postCommentRepository.save(postComment);
	}
}
