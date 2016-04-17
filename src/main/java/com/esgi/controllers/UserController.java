package com.esgi.controllers;

import com.esgi.model.MovieEntity;
import com.esgi.model.ReviewEntity;
import com.esgi.model.User;
import com.esgi.services.MovieService;
import com.esgi.services.UserService;
import com.esgi.utils.MovieUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Arnaud on 17/04/2016.
 */
@Controller
public class UserController {

    private UserService _userService;

    @Autowired
    private MovieService movieService;

    @Autowired
    public UserController(UserService userService) {
        _userService = userService;
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        user = _userService.authenticateUser(user.getPseudo(), user.getPassword());
        List<MovieEntity> listMovies = movieService.getLastMovies();
        for (MovieEntity movie : listMovies) {
            BigDecimal rating = new BigDecimal(0.0);
            if (movie.getListReviews().size() > 0) {
                for (ReviewEntity review : movie.getListReviews()) {
                    rating = rating.add(review.getRating());
                }
                movie.setNote(rating.divide(new BigDecimal(movie.getListReviews().size())));
            }
        }
        model.addAttribute("user", user);
        model.addAttribute("listMovies", listMovies);
        model.addAttribute("movieUtils", new MovieUtils());
        return("index");
    }
}