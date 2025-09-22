package org.eppay.api.domain.storeProductMapCategory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.eppay.api.common.model.BaseCommEntity;
import org.eppay.api.domain.storeProduct.model.StoreProductEntity;
import org.eppay.api.domain.storeProductCategory.model.StoreProductCategoryEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "store_product_map_category")
public class StoreProductMapCategoryEntity extends BaseCommEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "storeId")
    private Long storeId;

    @Column(name = "store_product_id",insertable = false,updatable = false)
    private Long storeProductId;

    @JsonIgnore
    @Column(name = "store_product_category_id" ,insertable = false,updatable = false)
    private Long storeProductCategoryId;

    private Long ord;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_product_category_id")
    private StoreProductCategoryEntity storeProductCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_product_id")
    private StoreProductEntity storeProduct;
}
