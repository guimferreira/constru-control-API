package com.construcontrol.construcontrol.model.domain.users;

import com.construcontrol.construcontrol.model.domain.users.enums.MaritialStatus;
import com.construcontrol.construcontrol.model.domain.users.enums.UserRole;
import com.construcontrol.construcontrol.DTO.users.ClientsDTO;

import com.construcontrol.construcontrol.shared.Address;
import jakarta.persistence.*;
import lombok.*;

@Entity
@SuppressWarnings("ALL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Clients extends User {

   @Enumerated(EnumType.STRING)
    private MaritialStatus maritalStatus;

    public Clients(ClientsDTO clientsDTO) {
        this.name = clientsDTO.name();
        this.phone = clientsDTO.phone();
        this.email = clientsDTO.email();
        this.cpf = clientsDTO.cpf();
        this.rg = clientsDTO.rg();
        this.maritalStatus = MaritialStatus.valueOf(clientsDTO.maritalStatus());
        this.address = clientsDTO.address() != null ? new Address(clientsDTO.address()) : null;
        super.setUserRole(UserRole.CLIENTE);


    }

    public void update(ClientsDTO payload) {
        this.name = payload.name();
        this.phone = payload.phone();
        this.email = payload.email();
        this.cpf = payload.cpf();
        this.rg = payload.rg();
        this.maritalStatus = MaritialStatus.valueOf(payload.maritalStatus());
        this.address = payload.address() != null ? new Address(payload.address()) : null;
    }

}
