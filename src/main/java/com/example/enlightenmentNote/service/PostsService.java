package com.example.enlightenmentNote.service;

import com.example.enlightenmentNote.domain.categories.Categories;
import com.example.enlightenmentNote.domain.categories.CategoriesRepo;
import com.example.enlightenmentNote.domain.posts.Posts;
import com.example.enlightenmentNote.domain.posts.PostsRepo;
import com.example.enlightenmentNote.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepo postsRepo;
    private final CategoriesRepo categoriesRepo;

    @Transactional(readOnly = true)
    public Page<PostsListResDto> findPostsList(PostsListReqDto reqDto, Pageable pageable) {
        return postsRepo.findPostsList(reqDto, pageable);
    }

    @Transactional(readOnly = true)
    public PostsDetailResDto findById(UUID postSeq) {
        Posts posts = postsRepo.findById(postSeq)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. postSeq=" + postSeq));

        return new PostsDetailResDto(posts);
    }

    @Transactional
    public UUID save(PostsSaveReqDto reqDto) {
        Categories categories = categoriesRepo.findById(reqDto.getCategorySeq())
                .orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 없습니다. postSeq=" + reqDto.getCategorySeq()));

        return postsRepo.save(reqDto.toEntity(categories)).getPostSeq();
    }

    @Transactional
    public UUID update(UUID postSeq, PostsUpdateReqDto reqDto) {
        Posts posts = postsRepo.findById(postSeq)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. postSeq=" + postSeq));

        Categories categories = categoriesRepo.findById(reqDto.getCategorySeq())
                .orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 없습니다. postSeq=" + reqDto.getCategorySeq()));

        posts.update(reqDto.getTitle(), reqDto.getContent(), categories);

        return postSeq;
    }

    @Transactional
    public void delete (UUID postSeq) {
        Posts posts = postsRepo.findById(postSeq)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. postSeq=" + postSeq));

        postsRepo.delete(posts);
    }
}
