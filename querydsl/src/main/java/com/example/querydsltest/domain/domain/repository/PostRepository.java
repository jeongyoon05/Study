package com.example.querydsltest.domain.domain.repository;

import com.example.querydsltest.domain.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
}
