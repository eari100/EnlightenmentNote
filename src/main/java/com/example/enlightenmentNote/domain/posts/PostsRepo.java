package com.example.enlightenmentNote.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostsRepo extends JpaRepository<Posts, UUID>, PostsRepoCustom {
}
