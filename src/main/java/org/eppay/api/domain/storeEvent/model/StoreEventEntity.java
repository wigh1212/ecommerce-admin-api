package org.eppay.api.domain.storeEvent.model;

import jakarta.persistence.*;
import lombok.*;
import org.eppay.api.common.model.BaseCommEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "store_event")
public class StoreEventEntity extends BaseCommEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "link")
    private String link;

}
