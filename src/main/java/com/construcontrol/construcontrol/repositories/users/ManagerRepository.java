package com.construcontrol.construcontrol.repositories.users;

import com.construcontrol.construcontrol.model.domain.users.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
