package org.eppay.api.domain.store.model;

import jakarta.persistence.*;
import lombok.*;
import org.eppay.api.common.enums.admin.PermissionEnum;
import org.eppay.api.common.model.BaseCommEntity;
import org.eppay.api.domain.storeEvent.model.StoreEventEntity;
import org.eppay.api.domain.storeProduct.model.StoreProductEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "store")
public class StoreEntity extends BaseCommEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "business_number")
    private String businessNumber;
    @Column(name = "ceo")
    private String ceo;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "image")
    private String image;
    @Column(name = "status")
    private String status;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id")
    private List<StoreProductEntity> storeProductList;

//    select se1_0.id,se1_0.address,se1_0.business_number,se1_0.created_at,se1_0.created_by,se1_0.email,se1_0.image,se1_0.name,se1_0.phone,se1_0.status,se1_0.updated_at,se1_0.updated_by from store se1_0 where se1_0.id=
//    select se1_0.id,se1_0.address,se1_0.business_number,se1_0.created_at,se1_0.created_by,se1_0.email,se1_0.image,se1_0.name,se1_0.phone,se1_0.status,spl1_0.store_id,spl1_0.id,spl1_0.amount,spl1_0.created_at,spl1_0.created_by,spl1_0.image,spl1_0.info,spl1_0.name,spl1_0.updated_at,spl1_0.updated_by,se1_0.updated_at,se1_0.updated_by from store se1_0 join store_product spl1_0 on se1_0.id=spl1_0.store_id where se1_0.id=?
//    select se1_0.id,se1_0.address,se1_0.business_number,se1_0.created_at,se1_0.created_by,se1_0.email,se1_0.image,se1_0.name,se1_0.phone,se1_0.status,se1_0.updated_at,se1_0.updated_by,spl1_0.store_id,spl1_0.id,spl1_0.amount,spl1_0.created_at,spl1_0.created_by,spl1_0.image,spl1_0.info,spl1_0.name,spl1_0.updated_at,spl1_0.updated_by from store se1_0 left join store_product spl1_0 on se1_0.id=spl1_0.store_id where se1_0.id=?

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id")
    private List<StoreEventEntity> storeEventList;


}
