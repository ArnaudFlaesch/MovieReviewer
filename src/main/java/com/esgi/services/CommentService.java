package com.esgi.services;

import com.esgi.model.CommentEntity;
import com.esgi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Arnaud on 15/04/2016.
 */
@Service
public class CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void addComment(CommentEntity comment) {
        commentRepository.save(comment);
    }

    public void updateComment(CommentEntity comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(CommentEntity comment) {
        commentRepository.delete(comment);
    }

}
