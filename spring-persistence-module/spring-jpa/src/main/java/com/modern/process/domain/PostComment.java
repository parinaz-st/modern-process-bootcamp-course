package com.modern.process.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post_comment" ,schema = "public")
public class PostComment {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "post_review", length = 50, nullable = false)
    private String review;

    @Transient
    private int code;
    @Temporal(TemporalType.TIMESTAMP)
    private Date comment_date;


    @Enumerated(EnumType.STRING)
    private CommentType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "post_id")
    private Post post;

    public PostComment() {
    }

    public PostComment(Long id, String review,  Date comment_date, CommentType type) {
        this.id = id;
        this.review = review;
        this.comment_date = comment_date;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }
    public CommentType getType() {
        return type;
    }

    public void setType(CommentType type) {
        this.type = type;
    }
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

}
