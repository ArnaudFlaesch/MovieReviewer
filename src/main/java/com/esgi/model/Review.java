package com.esgi.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Arnaud Flaesch on 13/04/2016.
 */
@Entity
@IdClass(ReviewPK.class)
@Table(name = "reviews", schema = "moviereviewer")
public class Review {

    private Long idmovie;
    private BigDecimal rating;
    private Long iduser;

    @Id
    @Column(name = "iduser")
    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    @Id
    @Column(name = "idmovie")
    public Long getIdmovie() {
        return idmovie;
    }

    public void setIdmovie(Long idmovie) {
        this.idmovie = idmovie;
    }

    @Basic
    @Column(name = "rating")
    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }
}
