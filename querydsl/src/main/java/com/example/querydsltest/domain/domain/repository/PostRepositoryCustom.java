package com.example.querydsltest.domain.domain.repository;

import com.example.querydsltest.domain.api.dto.response.QueryPostResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostRepositoryCustom {
    List<QueryPostResponse> searchPostList(String keyword, Pageable pageable);
}
