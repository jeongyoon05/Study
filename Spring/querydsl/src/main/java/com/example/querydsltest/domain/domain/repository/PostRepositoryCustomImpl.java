package com.example.querydsltest.domain.domain.repository;

import com.example.querydsltest.domain.api.dto.response.QQueryPostResponse_PostResponse;
import com.example.querydsltest.domain.api.dto.response.QueryPostResponse.PostResponse;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.example.querydsltest.domain.domain.QPost.post;


@RequiredArgsConstructor
public class PostRepositoryCustomImpl implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<PostResponse> searchPostList(String keyword, Pageable pageable) {
        return queryFactory
                .select(new QQueryPostResponse_PostResponse(
                        post.title,
                        post.content
                ))
                .from(post)
                .where(post.title.contains(keyword))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }
}
