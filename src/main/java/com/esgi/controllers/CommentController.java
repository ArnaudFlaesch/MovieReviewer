package com.esgi.controllers;

import com.esgi.model.CommentEntity;
import com.esgi.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Arnaud on 15/04/2016.
 */
@Controller
@RequestMapping("/movies/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCommentaire(@ModelAttribute CommentEntity commentaire, Model model) {
        commentService.addComment(commentaire);
        return ("detailMovie");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateCommentaire(@ModelAttribute CommentEntity commentaire, Model model) {
        commentService.updateComment(commentaire);
        return ("detailMovie");
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String deleteCommentaire(@ModelAttribute CommentEntity commentaire, Model model) {
        commentService.deleteComment(commentaire);
        return ("detailMovie");
    }


}
