package org.eppay.api.domain.storeProductCategory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.eppay.api.common.model.BaseCommEntity;
import org.eppay.api.domain.storeProduct.model.StoreProductEntity;
import org.eppay.api.domain.storeProductCategoryRel.model.StoreProductCategoryRelEntity;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "store_product_category")
public class StoreProductCategoryEntity extends BaseCommEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "status")
    private boolean status;


    @JsonIgnore
    @OneToMany(mappedBy = "storeProductCategory", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<StoreProductCategoryRelEntity> storeProductCategoryRelList = new ArrayList<>();

    public void addProduct(StoreProductEntity product) {
        boolean exists = this.storeProductCategoryRelList.stream()
                .anyMatch(map -> map.getStoreProduct().getId().equals(product.getId()));

        if (!exists) {
            StoreProductCategoryRelEntity rel = StoreProductCategoryRelEntity.builder()
                    .storeId(this.storeId)
                    .storeProduct(product)
                    .storeProductCategory(this)
                    .build();
            this.storeProductCategoryRelList.add(rel);
        }
    }

    public void removeAllProducts() {
        for (StoreProductCategoryRelEntity storeProductCategoryRelEntity : storeProductCategoryRelList) {
            storeProductCategoryRelEntity.setStoreProductCategory(null); // 주인 쪽 끊어주기
            storeProductCategoryRelEntity.setStoreProduct(null);
        }
        storeProductCategoryRelList.clear();
    }
}
