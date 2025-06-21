package org.eppay.api.domain.storeEvent.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStoreEventEntity is a Querydsl query type for StoreEventEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreEventEntity extends EntityPathBase<StoreEventEntity> {

    private static final long serialVersionUID = -76862661L;

    public static final QStoreEventEntity storeEventEntity = new QStoreEventEntity("storeEventEntity");

    public final org.eppay.api.common.model.QBaseCommEntity _super = new org.eppay.api.common.model.QBaseCommEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final StringPath link = createString("link");

    public final StringPath name = createString("name");

    public final NumberPath<Long> storeId = createNumber("storeId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QStoreEventEntity(String variable) {
        super(StoreEventEntity.class, forVariable(variable));
    }

    public QStoreEventEntity(Path<? extends StoreEventEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStoreEventEntity(PathMetadata metadata) {
        super(StoreEventEntity.class, metadata);
    }

}

