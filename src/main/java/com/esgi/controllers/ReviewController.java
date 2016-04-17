package com.esgi.controllers;

import com.esgi.model.*;
import com.esgi.services.MovieService;
import com.esgi.services.ReviewService;
import com.esgi.utils.MovieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;

/**
 * Created by Arnaud Flaesch on 15/04/2016.
 */

@Controller
@RequestMapping("/movies/reviews")
public class ReviewController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(method = RequestMethod.POST)
    public String addReview(@ModelAttribute ReviewEntity review, Model model) {
        reviewService.addReview(review);
        BigDecimal rating = new BigDecimal(0.0);
        Long iduser = SessionUser.getIduser();
        MovieEntity movie = movieService.getDetailMovie(review.getIdmovie());
        boolean hasReviewed = false;
        if (movie.getListReviews().size() > 0) {
            for (ReviewEntity reviewMovie : movie.getListReviews()) {
                rating = rating.add(reviewMovie.getRating());
                if (reviewMovie.getIduser().equals(iduser)) {
                    hasReviewed = true;
                }
            }
            movie.setNote(rating.divide(new BigDecimal(movie.getListReviews().size())));
        }
        model.addAttribute("comment", new CommentEntity());
        model.addAttribute("hasReviewed", !hasReviewed);
        model.addAttribute("movie", movie);
        model.addAttribute("movieUtils", new MovieUtils());
        model.addAttribute("user", new User(SessionUser.getIduser(), SessionUser.getFirstName(), SessionUser.getName(), SessionUser.getPseudo(), SessionUser.getToken()));
        return("detailMovie");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateReview(@ModelAttribute ReviewEntity review, Model model) {
        reviewService.updateReview(review);
        model.addAttribute("user", new User(SessionUser.getIduser(), SessionUser.getFirstName(), SessionUser.getName(), SessionUser.getPseudo(), SessionUser.getToken()));
        return("detailMovie");
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String deleteReview(@ModelAttribute ReviewEntity review, Model model) {
        reviewService.deleteReview(review);
        model.addAttribute("user", new User(SessionUser.getIduser(), SessionUser.getFirstName(), SessionUser.getName(), SessionUser.getPseudo(), SessionUser.getToken()));
        return("detailMovie");
    }
}