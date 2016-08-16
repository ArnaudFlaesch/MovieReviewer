package com.esgi.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;


/**
 * Created by Arnaud Flaesch on 09/04/2016.
 */
@Entity
@Table(name = "movie", schema = "moviereviewer")
public class Movie {
    private Long idmovie;
    private String title;
    private String imageUrl;
    private String description;
    private Date dateRelease;
    private String genre;
    private BigDecimal note;

    public Movie() {
        this.dateRelease = new Date(1460990690);
    }

    @Id
    @GeneratedValue
    @Column(name = "idmovie")
    public Long getIdmovie() {
        return idmovie;
    }

    public void setIdmovie(Long idmovie) {
        this.idmovie = idmovie;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "date_release")
    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    @Basic
    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Transient
    public BigDecimal getNote() {
        return note;
    }

    public void setNote(BigDecimal note) {
        this.note = note;
    }

    private List<Review> listReviews;

    @OneToMany
    @JoinColumn(name = "idmovie")
    public List<Review> getListReviews() {
        return listReviews;
    }

    public void setListReviews(List<Review> listReviews) {
        this.listReviews = listReviews;
    }

    private List<Comment> listComments;

    @OneToMany
    @JoinColumn(name = "idmovie")
    public List<Comment> getListComments() {
        return listComments;
    }

    public void setListComments(List<Comment> listComments) {
        this.listComments = listComments;
    }
}
