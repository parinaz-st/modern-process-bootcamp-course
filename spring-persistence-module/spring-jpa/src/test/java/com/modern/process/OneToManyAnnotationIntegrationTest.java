package com.modern.process;

import com.modern.process.domain.CommentType;
import com.modern.process.domain.Post;
import com.modern.process.domain.PostComment;
import com.modern.process.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.DataFormatException;

@SpringBootTest
public class OneToManyAnnotationIntegrationTest {

    @Autowired
    PostRepository postRepository;
    @Test
    public void givenManyPostComments_WhenInsertPost_thenCreate1ToManyRelationship()
    {
        Post post = new Post(null, "post_many_Comment");
        Set<PostComment> postComments = new HashSet<>();
        PostComment postComment1 = new PostComment(null, "review 1", new Date(), CommentType.BAD);
        postComment1.setPost(post);
        postComments.add(postComment1);
        PostComment postComment2 = new PostComment(null, "review 2", new Date(), CommentType.GOOD);
        postComment2.setPost(post);
        postComments.add(postComment2);

        post.setPostCommentsSet(postComments);
        postRepository.save(post);
    }

    @Test
    public void givenOnePostComment_whenInsertPost_thenCreatesOneToManyRelationShip()
    {
        Post post = new Post(null, "one Comment");
        PostComment postComment = new PostComment(null, "review 3", new Date(), CommentType.GOOD);
        post.addComment(postComment);
        postRepository.save(post);


    }
}
