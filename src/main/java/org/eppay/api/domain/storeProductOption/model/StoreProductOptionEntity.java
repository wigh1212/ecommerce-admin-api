package org.eppay.api.domain.storeProductOption.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.eppay.api.common.model.BaseCommEntity;
import org.eppay.api.domain.storeProductCategoryRel.model.StoreProductCategoryRelEntity;
import org.eppay.api.domain.storeProductOptionItem.model.StoreProductOptionItemEntity;
import org.eppay.api.domain.storeProductOptionRel.model.StoreProductOptionRelEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "store_product_option")
public class StoreProductOptionEntity extends BaseCommEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "name")
    private String name;
    @Column(name = "required")
    private boolean required;
    @Column(name = "min_select_count")
    private int minSelectCount;
    @Column(name = "max_select_count")
    private int maxSelectCount;
    @Column(name="status")
    private boolean status;

    @JsonIgnore
    @OneToMany(mappedBy = "storeProductOption", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<StoreProductOptionRelEntity> storeProductOptionRelList = new ArrayList<>();

    @OneToMany(mappedBy = "storeProductOption", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<StoreProductOptionItemEntity> storeProductOptionItemList = new ArrayList<>();

}
