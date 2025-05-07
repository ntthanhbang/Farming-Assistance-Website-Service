package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.TransactionItem;
import com.farmingweb.farmingwebsite.entities.TransactionItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionItemRepository extends JpaRepository<TransactionItem, TransactionItemId> {
}
