package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.Review;
import com.farmingweb.farmingwebsite.entities.ReviewId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, ReviewId> {
}
