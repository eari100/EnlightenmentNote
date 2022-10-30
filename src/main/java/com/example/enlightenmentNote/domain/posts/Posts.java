package com.example.enlightenmentNote.domain.posts;

import com.example.enlightenmentNote.domain.BaseTimeEntity;
import com.example.enlightenmentNote.domain.categories.Categories;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID postSeq;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Categories categories;

    @Builder
    public Posts(String title, String content, String author, Categories categories) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.categories = categories;
    }

    public void update(String title, String content, Categories categories) {
        this.title = title;
        this.content = content;
        this.categories = categories;
    }

}
