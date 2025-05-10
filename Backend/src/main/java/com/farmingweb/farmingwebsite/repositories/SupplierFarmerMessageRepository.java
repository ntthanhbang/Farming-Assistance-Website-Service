package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.SupplierFarmerMessage;
import com.farmingweb.farmingwebsite.entities.SupplierFarmerMessageId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierFarmerMessageRepository extends JpaRepository<SupplierFarmerMessage, SupplierFarmerMessageId> {
    //Get messages between supplier and farmer
    List<SupplierFarmerMessage> findBySupplierIDAndFarmerID(String supplierID, String farmerID);

    //Get list of UNIQUE farmers that supplier messaged
    @Query("SELECT DISTINCT m.farmerID FROM SupplierFarmerMessage m WHERE m.supplierID = :supplierID")
    List<String> findDistinctFarmerIDsBySupplierID(String supplierID);
}
