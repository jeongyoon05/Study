package com.example.querydsltest.domain.api;

import com.example.querydsltest.domain.api.dto.request.PostRequest;
import com.example.querydsltest.domain.api.dto.response.QueryPostResponse;
import com.example.querydsltest.domain.service.AddPostService;
import com.example.querydsltest.domain.service.QueryPostSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final AddPostService addPostService;
    private final QueryPostSearchService queryPostSearchService;

    @PostMapping
    public void addPost(@RequestBody PostRequest request) {
        addPostService.execute(request);
    }

    @GetMapping
    public QueryPostResponse searchPostList(@RequestParam String keyword,
                                            @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return queryPostSearchService.execute(keyword, pageable);
    }
}
