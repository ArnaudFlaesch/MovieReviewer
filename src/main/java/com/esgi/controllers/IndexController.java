package com.esgi.controllers;

import com.esgi.model.MovieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String getListMovies(Model model) {
        model.addAttribute("movieUtils", new MovieUtils());
        return ("index");
    }
}