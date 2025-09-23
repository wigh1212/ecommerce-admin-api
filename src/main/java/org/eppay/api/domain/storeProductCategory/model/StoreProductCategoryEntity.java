package org.eppay.api.domain.storeProductCategory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.eppay.api.common.model.BaseCommEntity;
import org.eppay.api.domain.storeProduct.model.StoreProductEntity;
import org.eppay.api.domain.storeProductMapCategory.model.StoreProductMapCategoryEntity;

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
    private List<StoreProductMapCategoryEntity> storeProductMapCategoryList = new ArrayList<>();

    public void addProduct(StoreProductEntity product) {
        boolean exists = this.storeProductMapCategoryList.stream()
                .anyMatch(map -> map.getStoreProduct().getId().equals(product.getId()));

        if (!exists) {
            StoreProductMapCategoryEntity map = StoreProductMapCategoryEntity.builder()
                    .storeId(this.storeId)
                    .storeProduct(product)
                    .storeProductCategory(this)
                    .build();
            this.storeProductMapCategoryList.add(map);
        }
    }

    public void removeAllProducts() {
        for (StoreProductMapCategoryEntity storeProductMapCategoryEntity : storeProductMapCategoryList) {
            storeProductMapCategoryEntity.setStoreProductCategory(null); // 주인 쪽 끊어주기
            storeProductMapCategoryEntity.setStoreProduct(null);
        }
        storeProductMapCategoryList.clear();
    }
}
