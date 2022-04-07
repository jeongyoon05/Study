package com.example.querydsltest.domain.api.dto.response;

import com.querydsl.core.annotations.QueryProjection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class QueryPostResponse {

    private final String title;
    private final String content;

    @QueryProjection
    public QueryPostResponse(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
