package org.eppay.api.common.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseCommEntity is a Querydsl query type for BaseCommEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseCommEntity extends EntityPathBase<BaseCommEntity> {

    private static final long serialVersionUID = 220429881L;

    public static final QBaseCommEntity baseCommEntity = new QBaseCommEntity("baseCommEntity");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final StringPath updatedBy = createString("updatedBy");

    public QBaseCommEntity(String variable) {
        super(BaseCommEntity.class, forVariable(variable));
    }

    public QBaseCommEntity(Path<? extends BaseCommEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseCommEntity(PathMetadata metadata) {
        super(BaseCommEntity.class, metadata);
    }

}

