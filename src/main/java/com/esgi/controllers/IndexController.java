package com.esgi.controllers;

import com.esgi.services.ReviewService;
import com.esgi.utils.MovieUtils;
import com.esgi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ReviewService reviewService;

    @RequestMapping("/")
    public String getListMovies(Model model) {
        model.addAttribute("movieUtils", new MovieUtils());
        model.addAttribute("lastMovies", movieService.getLastMovies());
        return ("index");
    }
}