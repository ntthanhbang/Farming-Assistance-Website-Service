package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.Review;
import com.farmingweb.farmingwebsite.entities.ReviewId;
import com.farmingweb.farmingwebsite.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    public Review create(Review obj) {
        return reviewRepository.save(obj);
    }

    public void delete(ReviewId id) {
        reviewRepository.deleteById(id);
    }
}
