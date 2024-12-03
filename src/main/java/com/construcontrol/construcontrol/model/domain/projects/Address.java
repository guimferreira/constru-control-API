package com.construcontrol.construcontrol.model.domain.projects;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "zip_code", nullable = false)
    private String cep;
    @Column(name = "street_address", nullable = false)
    private String logradouro;
    @Column(name = "complement", nullable = false)
    private String complemento;
    @Column(name = "neighborhood", nullable = false)
    private String bairro;
    @Column(name = "city", nullable = false)
    private String localidade;
    @Column(name = "state", nullable = false)
    private String uf;

}
