package org.eppay.api.domain.storeProductOptionRel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.eppay.api.common.model.BaseCommEntity;
import org.eppay.api.domain.storeProduct.model.StoreProductEntity;
import org.eppay.api.domain.storeProductOption.model.StoreProductOptionEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "store_product_option_rel")
public class StoreProductOptionRelEntity extends BaseCommEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "storeId")
    private Long storeId;

    @Column(name = "store_product_id",insertable = false,updatable = false)
    private Long storeProductId;

    @JsonIgnore
    @Column(name = "store_product_option_id" ,insertable = false,updatable = false)
    private Long storeProductOptionId;

    private Long ord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_product_option_id")
    private StoreProductOptionEntity storeProductOption;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_product_id")
    private StoreProductEntity storeProduct;
}
