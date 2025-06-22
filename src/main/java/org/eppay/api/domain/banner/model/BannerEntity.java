package org.eppay.api.domain.banner.model;

import jakarta.persistence.*;
import lombok.*;
import org.eppay.api.common.model.BaseCommEntity;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "banner")
public class BannerEntity extends BaseCommEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "image")
    private String image;
    @Column(name = "link")
    private String link;
    @Column(name = "type")
    private String type;
    @Column(name = "activate")
    private String activate;
    @Column(name = "apply_at")
    private LocalDateTime applyAt;
    @Column(name = "apply_by")
    private String applyBy;

}
