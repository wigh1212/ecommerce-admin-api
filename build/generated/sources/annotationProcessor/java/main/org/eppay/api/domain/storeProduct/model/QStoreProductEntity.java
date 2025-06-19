package org.eppay.api.domain.storeProduct.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStoreProductEntity is a Querydsl query type for StoreProductEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreProductEntity extends EntityPathBase<StoreProductEntity> {

    private static final long serialVersionUID = -1544802277L;

    public static final QStoreProductEntity storeProductEntity = new QStoreProductEntity("storeProductEntity");

    public final org.eppay.api.common.model.QBaseCommEntity _super = new org.eppay.api.common.model.QBaseCommEntity(this);

    public final NumberPath<Double> amount = createNumber("amount", Double.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final StringPath info = createString("info");

    public final StringPath name = createString("name");

    public final NumberPath<Long> storeId = createNumber("storeId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QStoreProductEntity(String variable) {
        super(StoreProductEntity.class, forVariable(variable));
    }

    public QStoreProductEntity(Path<? extends StoreProductEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStoreProductEntity(PathMetadata metadata) {
        super(StoreProductEntity.class, metadata);
    }

}

