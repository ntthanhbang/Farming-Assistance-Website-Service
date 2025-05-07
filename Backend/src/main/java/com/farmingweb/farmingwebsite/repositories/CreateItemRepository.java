package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.CreateItem;
import com.farmingweb.farmingwebsite.entities.CreateItemId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateItemRepository extends JpaRepository<CreateItem,CreateItemId> {
}
