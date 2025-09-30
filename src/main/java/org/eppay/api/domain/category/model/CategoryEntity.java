package org.eppay.api.domain.category.model;

import jakarta.persistence.*;
import lombok.*;
import org.eppay.api.common.model.BaseCommEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private boolean status;

}
