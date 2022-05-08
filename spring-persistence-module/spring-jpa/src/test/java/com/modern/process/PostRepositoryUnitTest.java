package com.modern.process;

import com.modern.process.domain.Post;
import com.modern.process.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostRepositoryUnitTest {

    @Autowired
    private PostRepository postRepository;
    @Test
    public void givenSavedPost_whenUpdate_ThenReturnUpdatedPost()
    {
        final String POST_NAME_2 = "post_22";
        postRepository.save(new Post(null, "post_2"));
        Post post1 = postRepository.findById(3L).get();
        post1.setTitle("post_22");
        postRepository.save(post1);

        assertThat(postRepository.findById(3L).get().getTitle()).isEqualTo(POST_NAME_2);

    }
    @Test
    public void givenSavedPost_whenDelete_thenReturnDeletedPost()
    {
        postRepository.save(new Post(null, "post_33"));
        postRepository.save(new Post(null, "post_44"));

        postRepository.deleteById(5L);
        Boolean present = postRepository.findById(5L).isPresent();

        assertThat(present).isEqualTo(false);
    }
    @Test
    public void givenPostsInDB_whenFindAllWithSortedByTitle_ThenReturnPostsSorted()
    {
        final String POST_NAME_2 = "post22";

        postRepository.save(new Post(null, "post22"));
        postRepository.save(new Post(null, "post24"));
        postRepository.save(new Post(null, "post23"));

        List<Post> postSortedByTitle =  postRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
        assertThat(postSortedByTitle.get(0).getTitle()).isEqualTo(POST_NAME_2);
    }
    @Test
    public void givenPostsInDB_whenFindAllWithPageRequestQuery_ThenReturnPageOfPosts()
    {
        postRepository.save(new Post(null, "post_1"));
        postRepository.save(new Post(null, "post_2"));
        postRepository.save(new Post(null, "post_3"));
        postRepository.save(new Post(null, "post_4"));
        postRepository.save(new Post(null, "post_5"));
        postRepository.save(new Post(null, "post_6"));

        Page<Post> postPage = postRepository.findAll(PageRequest.of(0,3));
        assertThat(postPage.getContent()
                .get(0)
                .getTitle()).isEqualTo("post_1");

    }
}
