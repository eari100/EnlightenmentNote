package com.example.enlightenmentNote.domain.posts;

import com.example.enlightenmentNote.dto.PostsListReqDto;
import com.example.enlightenmentNote.dto.PostsListResDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.enlightenmentNote.domain.posts.QPosts.posts;

@RequiredArgsConstructor
public class PostsRepoImpl implements PostsRepoCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<PostsListResDto> findPostsList(PostsListReqDto reqDto, Pageable pageable) {

        JPAQuery<Long> countQuery = findPostsListCount(reqDto);

        List<Posts> entities = jpaQueryFactory.selectFrom(posts)
                .where(containsTitle(reqDto.getTitle()), containsContent(reqDto.getContent()),
                        containsAuthor(reqDto.getAuthor()), eqCategorySeq(reqDto.getCategorySeq()))
                .limit(pageable.getPageSize()).offset(pageable.getOffset())
                .orderBy(posts.createdDate.desc())
                .fetch();

        List<PostsListResDto> resDto = entities.stream()
                .map(post -> new PostsListResDto(post))
                .collect(Collectors.toList());

        return new PageImpl(resDto, pageable, countQuery.fetchOne());
    }

    private JPAQuery<Long> findPostsListCount(PostsListReqDto reqDto) {
        JPAQuery<Long> countQuery = jpaQueryFactory.select(posts.count())
                .from(posts)
                .where(containsTitle(reqDto.getTitle()), containsContent(reqDto.getContent()),
                        containsAuthor(reqDto.getAuthor()), eqCategorySeq(reqDto.getCategorySeq()));

        return countQuery;
    }

    private BooleanExpression containsTitle(String title) {
        if (!StringUtils.hasText(title)) return null;
        
        return posts.title.contains(title);
    }

    private BooleanExpression containsContent(String content) {
        if (!StringUtils.hasText(content)) return null;

        return posts.title.contains(content);
    }

    private BooleanExpression containsAuthor(String author) {
        if (!StringUtils.hasText(author)) return null;

        return posts.author.contains(author);
    }

    private BooleanExpression eqCategorySeq(String categorySeq) {
        if (!StringUtils.hasText(categorySeq)) return null;

        return posts.categories.categorySeq.eq(UUID.fromString(categorySeq));
    }
}
