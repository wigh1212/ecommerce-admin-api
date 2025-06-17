package org.eppay.api.common.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.eppay.api.util.AuthUtils;

import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
public class BaseCommEntity {
    @Column(name = "CREATED_AT")
    @CreationTimestamp
    protected LocalDateTime  createdAt;

    @Column(name = "CREATED_BY", updatable = false)
    protected String createdBy;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    protected LocalDateTime  updatedAt;

    @Column(name = "UPDATED_BY")
    protected String updatedBy;

    @PrePersist
    protected void onPersist() {
        this.createdBy = this.updatedBy = AuthUtils.getCurrentLoginUserCd();
        // createdAt은 @CreationTimestamp에 의해 자동으로 설정됨
        // updatedAt도 @CreationTimestamp에 의해 자동으로 설정됨
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedBy = AuthUtils.getCurrentLoginUserCd();
        // updatedAt은 @UpdateTimestamp에 의해 자동으로 설정됨
    }

}
