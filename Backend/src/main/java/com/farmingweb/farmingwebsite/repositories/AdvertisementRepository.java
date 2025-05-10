package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.Advertisement;
import com.farmingweb.farmingwebsite.entities.AdvertisementId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, AdvertisementId> {
    List<Advertisement> findBySupplier_SupplierID(String supplierID);
}
