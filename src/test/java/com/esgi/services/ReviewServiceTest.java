package com.esgi.services;

import com.esgi.model.MovieEntity;
import com.esgi.model.ReviewEntity;
import com.esgi.repository.MovieRepository;
import com.esgi.repository.ReviewRepository;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class ReviewServiceTest {

    @InjectMocks
    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepository;

    private ReviewEntity review = new ReviewEntity();

    @Test
    public void should_modify_rating() {
        review.setRating(new BigDecimal(30));
        reviewRepository.save(review);
    }
}