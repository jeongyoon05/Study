package com.example.querydsltest.domain.service;

import com.example.querydsltest.domain.api.dto.request.PostRequest;
import com.example.querydsltest.domain.domain.Post;
import com.example.querydsltest.domain.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddPostService {

    private final PostRepository postRepository;

    @Transactional
    public void execute(PostRequest request) {
        postRepository.save(Post.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build());
    }
}
