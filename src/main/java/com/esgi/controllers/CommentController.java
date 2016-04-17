package com.esgi.controllers;

import com.esgi.model.CommentEntity;
import com.esgi.services.CommentService;
import com.esgi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/movies/comments")
public class CommentController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.POST)
    public String addComment(@ModelAttribute CommentEntity comment, Model model) {
        commentService.addComment(comment);
        model.addAttribute("movie", movieService.getDetailMovie(comment.getIdmovie()));
        return ("detailMovie");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateComment(@ModelAttribute CommentEntity comment, Model model) {
        commentService.updateComment(comment);
        return ("detailMovie");
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String deleteComment(@ModelAttribute CommentEntity comment, Model model) {
        commentService.deleteComment(comment);
        return ("detailMovie");
    }


}
