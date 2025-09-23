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

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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
    private boolean status;

}
