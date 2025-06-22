package org.eppay.api.domain.user.model;

import jakarta.persistence.*;
import lombok.*;
import org.eppay.api.common.model.BaseCommEntity;
import org.eppay.api.domain.storeEvent.model.StoreEventEntity;
import org.eppay.api.domain.storeProduct.model.StoreProductEntity;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "user")
public class UserEntity extends BaseCommEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "address_detail")
    private String addressDetail;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "email")
    private String email;

}
