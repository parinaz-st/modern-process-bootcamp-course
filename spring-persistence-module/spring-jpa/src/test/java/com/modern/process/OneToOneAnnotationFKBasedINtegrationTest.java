package com.modern.process;

import com.modern.process.domain.Post;
import com.modern.process.domain.PostDetails;
import com.modern.process.repository.PostDetailsRepository;
import com.modern.process.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class OneToOneAnnotationFKBasedINtegrationTest {
    @Autowired
    PostDetailsRepository postDetailsRepository;
    @Autowired
    PostRepository postRepository;
    @Test
    public void whenInsertPost_then_createOneToONeRelationship()
    {
        Post post = new Post(null, "post_new");
        PostDetails postDetails = new PostDetails(null, null, "admin");

        postDetails.setPost(post);
        post.setPostDetails(postDetails);

        postDetailsRepository.save(postDetails);
    }
    @Test
    public void whenInsertPostDetails_then_createOneToONeRelationship()
    {
        Post post = new Post(null, "post_new2");
        PostDetails postDetails = new PostDetails(null, null, "admin2");

        postDetails.setPost(post);
        post.setPostDetails(postDetails);

        postRepository.save(post);
    }
}
