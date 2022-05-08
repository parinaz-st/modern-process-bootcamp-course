package com.modern.process.repository;

import com.modern.process.domain.PostDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDetailsRepository extends JpaRepository<PostDetails, Long> {
}
