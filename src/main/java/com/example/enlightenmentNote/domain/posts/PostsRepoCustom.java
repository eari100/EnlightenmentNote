package com.example.enlightenmentNote.domain.posts;

import com.example.enlightenmentNote.dto.PostsListReqDto;
import com.example.enlightenmentNote.dto.PostsListResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostsRepoCustom {
    Page<PostsListResDto> findPostsList(PostsListReqDto reqDto, Pageable pageable);
}
