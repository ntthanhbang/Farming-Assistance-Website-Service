package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.SupplierFarmerMessage;
import com.farmingweb.farmingwebsite.entities.SupplierFarmerMessageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierFarmerMessageRepository extends JpaRepository<SupplierFarmerMessage, SupplierFarmerMessageId> {
}
