package com.construcontrol.construcontrol.model.domain.projects;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Table(name = "apartaments")
public class Apartament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "construction_id", nullable = false, referencedColumnName = "id")
    private Construction construction;
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "area", nullable = false)
    private double area;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "sold_status", nullable = false)
    private boolean soldStatus = false;

}
