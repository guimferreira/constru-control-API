package com.construcontrol.construcontrol.repositories.projects;

import com.construcontrol.construcontrol.model.domain.projects.Apartament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartamentRepository extends JpaRepository<Apartament, Long> {

    @Query("SELECT a FROM Apartament a WHERE a.construction = :construction")
    List<Apartament> findByConstruction(@Param("construction") String construction);

}
