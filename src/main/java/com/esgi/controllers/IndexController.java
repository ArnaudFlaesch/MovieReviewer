package com.esgi.controllers;

import com.esgi.model.MovieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.esgi.model.MovieEntity;

import javax.json.JsonObject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String getListMovies(Model model) {
        model.addAttribute("movieUtils", new MovieUtils());

        ArrayList<MovieEntity> listMovies = new ArrayList();

        MovieEntity movie = new MovieEntity();
        listMovies.add(movie);

        model.addAttribute(listMovies);
        return ("index");
    }
}