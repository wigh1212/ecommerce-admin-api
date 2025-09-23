package org.eppay.api.domain.storeProduct.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.eppay.api.common.model.BaseCommEntity;
import org.eppay.api.domain.storeProductCategoryRel.model.StoreProductCategoryRelEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "store_product")
public class StoreProductEntity extends BaseCommEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "name")
    private String name;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "image")
    private String image;
    @Column(name = "info")
    private String info;
    @Column(name="status")
    private boolean status;

    @JsonIgnore
    @OneToMany(mappedBy = "storeProduct", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<StoreProductCategoryRelEntity> storeProductCategoryRelList = new ArrayList<>();

    // 연관관계 편의 메서드
    public void addMap(StoreProductCategoryRelEntity storeProductCategoryRel) {
        storeProductCategoryRelList.add(storeProductCategoryRel);
        storeProductCategoryRel.setStoreProduct(this);
    }

}
