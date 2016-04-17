package com.esgi.repository;

import com.esgi.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Arnaud on 15/04/2016.
 */
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}
