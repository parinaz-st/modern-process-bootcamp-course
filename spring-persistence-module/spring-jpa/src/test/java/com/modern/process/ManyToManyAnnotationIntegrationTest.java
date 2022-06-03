package com.modern.process;

import com.modern.process.domain.Post;
import com.modern.process.domain.PostTag;
import com.modern.process.domain.Tag;
import com.modern.process.repository.PostRepository;
import com.modern.process.repository.TagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyToManyAnnotationIntegrationTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    TagRepository.PostTagRepository postTagRepository;

//    @Test
//    public void givenPostAndTags_whenInsertPost_ThenCreateManyToManyRelatonShip()
//    {
//        Post post = new Post(null, "post_11");
//        Tag tag1  = new Tag(null, "bookstagram");
//        Tag tag2  = new Tag(null, "readList");
//
//        List<Tag> tagList = new ArrayList<>();
//        tagList.add(tag1);
//        tagList.add(tag2);
//        post.setTags(tagList);
//
//        postRepository.save(post);
//
//
//    }

    @Test
    public void givenPostAndTags_whenInsertPost_ThenCreateManyToManyRelatonShip()
    {
        Post post1 = new Post(null, "post_1");
        postRepository.save(post1);

        Tag tag1 = new Tag(null, "bookStagram");
        tagRepository.save(tag1);

        PostTag postTag = new PostTag();
        postTag.setPost(post1);
        postTag.setTag(tag1);

        postTagRepository.save(postTag);


    }
}
