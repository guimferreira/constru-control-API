package com.construcontrol.construcontrol.repositories;

import com.construcontrol.construcontrol.model.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Supplier getSupplierById(long id);
    Optional<Supplier> getSupplierByCnpj(String cnpj);

    Supplier deleteSupplierById(Long id);
    Optional<Supplier> deleteSupplierByCnpj(String cnpj);
}
