package com.esgi.repository;

import com.esgi.model.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by Arnaud Flaesch on 15/04/2016.
 */
@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

}
