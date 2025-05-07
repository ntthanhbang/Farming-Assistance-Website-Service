package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.Review;
import com.farmingweb.farmingwebsite.entities.ReviewId;
import com.farmingweb.farmingwebsite.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Review create(@RequestBody Review obj) {
        return reviewService.create(obj);
    }

    @DeleteMapping
    public void delete(@PathVariable ReviewId id) {
        reviewService.delete(id);
    }
}
