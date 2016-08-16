package com.esgi.repository;

import com.esgi.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Arnaud Flaesch on 15/04/2016.
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
