package com.esgi.controllers;

import com.esgi.model.ReviewEntity;
import com.esgi.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Arnaud Flaesch on 15/04/2016.
 */

@Controller
@RequestMapping("/movies/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(method = RequestMethod.POST)
    public String addReview(@ModelAttribute ReviewEntity reviewEntity) {
        reviewService.addReview(reviewEntity);
        return("detailMovie");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateReview(@ModelAttribute ReviewEntity reviewEntity) {
        reviewService.updateReview(reviewEntity);
        return("detailMovie");
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String deleteReview(@ModelAttribute ReviewEntity reviewEntity) {
        reviewService.deleteReview(reviewEntity);
        return("detailMovie");
    }
}