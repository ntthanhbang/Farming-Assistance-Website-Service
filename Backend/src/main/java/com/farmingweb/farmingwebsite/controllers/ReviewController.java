package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.Review;
import com.farmingweb.farmingwebsite.entities.ReviewId;
import com.farmingweb.farmingwebsite.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAll() {
        return reviewService.getAll();
    }

    @PostMapping
    public Review saveReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ReviewId id) {
        reviewService.delete(id);
    }
}
