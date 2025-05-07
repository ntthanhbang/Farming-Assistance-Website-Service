package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.FarmerFarmerMessage;
import com.farmingweb.farmingwebsite.entities.FarmerFarmerMessageId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerFarmerMessageRepository extends JpaRepository<FarmerFarmerMessage, FarmerFarmerMessageId> {
}
