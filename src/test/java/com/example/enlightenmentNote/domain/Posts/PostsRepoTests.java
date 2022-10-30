package com.example.enlightenmentNote.domain.Posts;

import com.example.enlightenmentNote.domain.categories.Categories;
import com.example.enlightenmentNote.domain.categories.CategoriesRepo;
import com.example.enlightenmentNote.domain.posts.Posts;
import com.example.enlightenmentNote.domain.posts.PostsRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostsRepoTests {

    @Autowired
    private PostsRepo postsRepo;

    @Autowired
    private CategoriesRepo categoriesRepo;

    @Transactional
    @Test
    public void 게시물_조회() {
        final String title = "제목";
        final String content = "본문";
        final String author = "김요한";
        final String categoryName = "깨점노트";
        LocalDateTime now = LocalDateTime.now();

        Categories category = categoriesRepo.save(new Categories(categoryName));

        postsRepo.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .categories(category)
                .build());

        Posts posts = postsRepo.findAll().get(0);

        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        assertThat(posts.getAuthor()).isEqualTo(author);
        assertThat(posts.getCategories().getName()).isEqualTo(categoryName);

        System.out.println(">>>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
