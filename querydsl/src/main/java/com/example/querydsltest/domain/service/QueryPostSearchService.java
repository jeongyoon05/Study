package com.example.querydsltest.domain.service;

import com.example.querydsltest.domain.api.dto.response.QueryPostResponse;
import com.example.querydsltest.domain.api.dto.response.QueryPostResponse.PostResponse;
import com.example.querydsltest.domain.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryPostSearchService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public QueryPostResponse execute(String keyword, Pageable pageable) {

        List<PostResponse> postResponseList = postRepository
                .searchPostList(keyword, pageable);

        return new QueryPostResponse(postResponseList);
    }
}
