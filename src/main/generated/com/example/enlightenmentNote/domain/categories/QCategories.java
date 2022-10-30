package com.example.enlightenmentNote.domain.categories;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCategories is a Querydsl query type for Categories
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCategories extends EntityPathBase<Categories> {

    private static final long serialVersionUID = -1503502147L;

    public static final QCategories categories = new QCategories("categories");

    public final com.example.enlightenmentNote.domain.QBaseTimeEntity _super = new com.example.enlightenmentNote.domain.QBaseTimeEntity(this);

    public final ComparablePath<java.util.UUID> categorySeq = createComparable("categorySeq", java.util.UUID.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public QCategories(String variable) {
        super(Categories.class, forVariable(variable));
    }

    public QCategories(Path<? extends Categories> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategories(PathMetadata metadata) {
        super(Categories.class, metadata);
    }

}

