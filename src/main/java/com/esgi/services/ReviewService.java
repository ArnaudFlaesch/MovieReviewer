package com.esgi.services;

import com.esgi.model.ReviewEntity;
import com.esgi.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by Arnaud Flaesch on 15/04/2016.
 */

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public BigDecimal getRating(Long idmovie) {
        return(reviewRepository.getRating(idmovie));
    }

    public void addReview(ReviewEntity reviewEntity) {
        reviewRepository.save(reviewEntity);
    }

    public void updateReview(ReviewEntity reviewEntity) {
        reviewRepository.save(reviewEntity);
    }

    public void deleteReview(ReviewEntity reviewEntity) {
        reviewRepository.delete(reviewEntity);
    }
}