package com.esgi.controllers;

import com.esgi.model.Movie;
import com.esgi.model.Review;
import com.esgi.model.SessionUser;
import com.esgi.model.User;
import com.esgi.utils.SearchUtils;
import com.esgi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/")
    public String getListMovies(@ModelAttribute User user, Model model) {
        model.addAttribute("searchUtils", new SearchUtils());
        List<Movie> listMovies = movieService.getLastMovies();
        for (Movie movie : listMovies) {
            BigDecimal rating = new BigDecimal(0.0);
            if (movie.getListReviews().size() > 0) {
                for (Review review : movie.getListReviews()) {
                    rating = rating.add(review.getRating());
                }
                movie.setNote(rating.divide(new BigDecimal(movie.getListReviews().size())));
            }
        }
        model.addAttribute("user", new User(SessionUser.getIduser(), SessionUser.getFirstName(), SessionUser.getName(), SessionUser.getPseudo(), SessionUser.getToken()));
        model.addAttribute("listMovies", listMovies);
        return ("index");
    }
}