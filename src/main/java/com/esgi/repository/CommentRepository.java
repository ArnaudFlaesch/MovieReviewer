package com.esgi.repository;

import com.esgi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Arnaud on 15/04/2016.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
