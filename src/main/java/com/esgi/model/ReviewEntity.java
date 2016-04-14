package com.esgi.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Arnaud Flaesch on 13/04/2016.
 */
@Entity
@Table(name = "reviews", schema = "moviereviewer")
public class ReviewEntity implements Serializable {

    private int idmovie;
    private float rating;
    private int iduser;

    @Id
    @Column(name = "iduser")
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }


    @Id
    @Column(name = "idmovie")
    public int getIdmovie() {
        return idmovie;
    }

    public void setIdmovie(int idmovie) {
        this.idmovie = idmovie;
    }

    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "iduser")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
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
