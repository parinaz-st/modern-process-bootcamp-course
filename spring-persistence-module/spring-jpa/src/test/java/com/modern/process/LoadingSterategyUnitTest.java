package com.modern.process;

import com.modern.process.domain.CommentType;
import com.modern.process.domain.Post;
import com.modern.process.domain.PostComment;
import com.modern.process.repository.PostCommentRepository;
import com.modern.process.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LoadingSterategyUnitTest {
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostCommentRepository postCommentRepository;
    @Test
    @Transactional
    public void whenPostLoadedLazy_thenLoadPostComment()
    {
        Post post = new Post(null, "post_many_Comment");
        Set<PostComment> postCommentSet = new HashSet<>();
        PostComment postComment1 = new PostComment(null, "review_1", new Date(), CommentType.BAD);
        PostComment postComment2 = new PostComment(null, "review_2", new Date(), CommentType.GOOD);
         postComment1.setPost(post);
         postComment2.setPost(post);

        postCommentSet.add(postComment1);
        postCommentSet.add(postComment2);

        post.setPostCommentsSet(postCommentSet);
        postRepository.save(post);

        List<Post> posts = postRepository.findAll();
        Post postLazyLoaded = posts.get(0);
        postLazyLoaded.getPostCommentsSet();
        assertThat(postLazyLoaded.getPostCommentsSet().iterator().next().getReview()).isEqualTo("review_2");

    }
    @Test
    @Transactional
    public void whenPostCommentLoaded_thenLoalPost()
    {
        Post post = new Post(null, "post_many_Comment");
        Set<PostComment> postCommentSet = new HashSet<>();
        PostComment postComment1 = new PostComment(null, "review_1", new Date(), CommentType.BAD);
        PostComment postComment2 = new PostComment(null, "review_2", new Date(), CommentType.GOOD);
        postComment1.setPost(post);
        postComment2.setPost(post);

        postCommentSet.add(postComment1);
        postCommentSet.add(postComment2);

        post.setPostCommentsSet(postCommentSet);
        postRepository.save(post);

        List<PostComment> postComments = postCommentRepository.findAll();
        PostComment postCommentLazy = postComments.get(1);
        Post post1 =postCommentLazy.getPost();
        assertThat(post1.getTitle()).isEqualTo("post_many_Comment");



    }
}
