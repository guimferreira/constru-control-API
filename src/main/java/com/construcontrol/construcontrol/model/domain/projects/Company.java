package com.construcontrol.construcontrol.model.domain.projects;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "company")
    private String company;
    @Column(name = "cnpj", unique = true, nullable = false, length = 14)
    private String cnpj;
    @Column(name = "zip_code", length = 8)
    private String cep;
    @Column(name = "street")
    private String logradouro;
    @Column(name = "complement")
    private String complemento;
    @Column(name = "neighborhood")
    private String bairro;
    @Column(name = "city")
    private String localidade;
    @Column(name = "state")
    private String uf;
}
