package org.eppay.api.domain.store.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreEntity is a Querydsl query type for StoreEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreEntity extends EntityPathBase<StoreEntity> {

    private static final long serialVersionUID = 1323010903L;

    public static final QStoreEntity storeEntity = new QStoreEntity("storeEntity");

    public final org.eppay.api.common.model.QBaseCommEntity _super = new org.eppay.api.common.model.QBaseCommEntity(this);

    public final StringPath address = createString("address");

    public final StringPath businessNumber = createString("businessNumber");

    public final StringPath ceo = createString("ceo");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final StringPath status = createString("status");

    public final ListPath<org.eppay.api.domain.storeEvent.model.StoreEventEntity, org.eppay.api.domain.storeEvent.model.QStoreEventEntity> storeEventList = this.<org.eppay.api.domain.storeEvent.model.StoreEventEntity, org.eppay.api.domain.storeEvent.model.QStoreEventEntity>createList("storeEventList", org.eppay.api.domain.storeEvent.model.StoreEventEntity.class, org.eppay.api.domain.storeEvent.model.QStoreEventEntity.class, PathInits.DIRECT2);

    public final ListPath<org.eppay.api.domain.storeProduct.model.StoreProductEntity, org.eppay.api.domain.storeProduct.model.QStoreProductEntity> storeProductList = this.<org.eppay.api.domain.storeProduct.model.StoreProductEntity, org.eppay.api.domain.storeProduct.model.QStoreProductEntity>createList("storeProductList", org.eppay.api.domain.storeProduct.model.StoreProductEntity.class, org.eppay.api.domain.storeProduct.model.QStoreProductEntity.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QStoreEntity(String variable) {
        super(StoreEntity.class, forVariable(variable));
    }

    public QStoreEntity(Path<? extends StoreEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStoreEntity(PathMetadata metadata) {
        super(StoreEntity.class, metadata);
    }

}

