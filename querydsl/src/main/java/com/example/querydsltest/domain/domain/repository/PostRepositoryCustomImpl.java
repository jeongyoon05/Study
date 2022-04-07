package com.example.querydsltest.domain.domain.repository;

import com.example.querydsltest.domain.api.dto.response.QQueryPostResponse;
import com.example.querydsltest.domain.api.dto.response.QueryPostResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.example.querydsltest.domain.domain.QPost.post;

@RequiredArgsConstructor
public class PostRepositoryCustomImpl implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<QueryPostResponse> searchPostList(String keyword, Pageable pageable) {
        return queryFactory
                .select(new QQueryPostResponse(
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
