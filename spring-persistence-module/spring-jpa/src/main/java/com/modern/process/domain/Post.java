package com.modern.process.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "post" ,schema = "public")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String title;
    public Post() {
    }

    public Post(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    PostDetails postDetails;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<PostComment> postCommentsSet = new HashSet<>();


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<PostTag> postTags = new ArrayList<>();
//    @ManyToMany(cascade = CascadeType.PERSIST)
//    @JoinTable(name = "post_tag",
//            joinColumns = @JoinColumn(name = "post_id"),
//            inverseJoinColumns = @JoinColumn(name = "tag_id"))
//    List<Tag> tags = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
    }
    public Set<PostComment> getPostCommentsSet() {
        return postCommentsSet;
    }

    public void setPostCommentsSet(Set<PostComment> postCommentsList) {
        this.postCommentsSet = postCommentsList;
    }

    public void addComment(PostComment postComment)
    {
         postCommentsSet.add(postComment);
         postComment.setPost(this);
    }
    public List<PostTag> getPostTags() {
        return postTags;
    }

    public void setPostTags(List<PostTag> postTags) {
        this.postTags = postTags;
    }
//    public List<Tag> getTags() {
//        return tags;
//    }
//
//    public void setTags(List<Tag> tags) {
//        this.tags = tags;
//    }

}
