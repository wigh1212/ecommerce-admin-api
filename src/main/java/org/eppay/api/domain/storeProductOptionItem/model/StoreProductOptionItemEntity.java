package org.eppay.api.domain.storeProductOptionItem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.eppay.api.common.model.BaseCommEntity;
import org.eppay.api.domain.storeProductCategoryRel.model.StoreProductCategoryRelEntity;
import org.eppay.api.domain.storeProductOption.model.StoreProductOptionEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "store_product_option_item")
public class StoreProductOptionItemEntity extends BaseCommEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "store_product_option_id")
    private Long storeProductOptionId;
    @Column(name = "name")
    private String name;
    @Column(name = "amount")
    private BigDecimal amount;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_product_option_id",insertable = false,updatable = false)
    private StoreProductOptionEntity storeProductOption;

}
