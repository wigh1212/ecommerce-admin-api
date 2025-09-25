package org.eppay.api.domain.adminLog.model;

import jakarta.persistence.*;
import lombok.*;
import org.eppay.api.common.enums.admin.PermissionEnum;
import org.eppay.api.common.model.BaseCommEntity;
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
@Table(name = "admin_log")
public class AdminLogEntity extends BaseCommEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "ip")
    private String ip;
    @Column(name = "path")
    private String path;
    @Column(name = "param")
    private String param;
}
