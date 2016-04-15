package com.esgi.model;

import javax.persistence.*;

/**
 * Created by Arnaud Flaesch on 13/04/2016.
 */
@Entity
@IdClass(ReviewEntityPK.class)
@Table(name = "reviews", schema = "moviereviewer")
public class ReviewEntity {

    private Long idmovie;
    private float rating;
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
    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
