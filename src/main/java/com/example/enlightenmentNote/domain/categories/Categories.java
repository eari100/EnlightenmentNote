package com.example.enlightenmentNote.domain.categories;

import com.example.enlightenmentNote.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
public class Categories extends BaseTimeEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID categorySeq;

    private String name;

    public Categories(String name) {
        this.name = name;
    }

    public void update(String name) {
        this.name = name;
    }

}
