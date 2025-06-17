package org.eppay.api.domain.admin.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.eppay.api.common.enums.admin.PermissionEnum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "admin")
public class AdminEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "type")
    private String type;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> roles = new ArrayList<>();
        if (!this.type.equals("ADMIN_TYPE_USER")) {
            roles = List.of(new SimpleGrantedAuthority(this.getType())
                    , new SimpleGrantedAuthority(PermissionEnum.READ.getCode())
                    , new SimpleGrantedAuthority(PermissionEnum.WRITE.getCode())
                    , new SimpleGrantedAuthority(PermissionEnum.DELETE.getCode()));
        } else {
            roles = List.of(new SimpleGrantedAuthority(this.getType())
                    , new SimpleGrantedAuthority(PermissionEnum.READ.getCode()));
        }

        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
