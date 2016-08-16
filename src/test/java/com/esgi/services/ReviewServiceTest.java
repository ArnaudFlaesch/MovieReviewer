package com.esgi.services;

import com.esgi.model.Review;
import com.esgi.repository.ReviewRepository;
import org.junit.Test;
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

    private Review review = new Review();

    @Test
    public void should_modify_rating() {
        review.setRating(new BigDecimal(30));
        reviewRepository.save(review);
    }
}