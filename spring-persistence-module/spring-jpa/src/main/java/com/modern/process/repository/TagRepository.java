package com.modern.process.repository;

import com.modern.process.domain.PostTag;
import com.modern.process.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    @Repository
    interface PostTagRepository extends JpaRepository<PostTag, Long> {
    }
}
