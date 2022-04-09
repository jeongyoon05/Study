package com.example.querydsltest.domain.api.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryPostResponse {

    public final List<PostResponse> postList;

    @Getter
    @Builder
    public static class PostResponse {

        private final String title;
        private final String content;

        @QueryProjection
        public PostResponse(String title, String content) {
            this.title = title;
            this.content = content;
        }
    }
}
