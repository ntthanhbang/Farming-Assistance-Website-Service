package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
}
