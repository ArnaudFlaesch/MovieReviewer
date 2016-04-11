package com.esgi.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Arnaud Flaesch on 09/04/2016.
 */
@Entity
@Table(name = "movie", schema = "moviereviewer")
public class MovieEntity {
    private int idmovie;
    private String title;
    private String imageUrl;
    private String description;
    private Date dateRelease;
    private int codeAllocine;

    @Id
    @GeneratedValue
    @Column(name = "idmovie")
    public int getIdmovie() {
        return idmovie;
    }

    public void setIdmovie(int idmovie) {
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
    @Column(name = "imageUrl")
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
    @Column(name = "dateRelease")
    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    @Basic
    @Column(name = "codeAllocine")
    public int getCodeAllocine() {
        return codeAllocine;
    }

    public void setCodeAllocine(int codeAllocine) {
        this.codeAllocine = codeAllocine;
    }

    private GenreEntity genre;

    @ManyToOne
    @JoinColumn(name="idgenre")
    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }
}
