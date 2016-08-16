package com.esgi.model;

import javax.persistence.*;

/**
 * Created by Arnaud on 14/04/2016.
 */
@Entity
@Table(name = "comment", schema = "moviereviewer")
public class Comment {
    private Long idcomment;
    private String comment;
    private Long idmovie;
    private Long iduser;

    @Id
    @GeneratedValue
    @Column(name = "idcomment")
    public Long getIdcomment() {
        return idcomment;
    }

    public void setIdcomment(Long idcomment) {
        this.idcomment = idcomment;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "idmovie")
    public Long getIdmovie() {
        return idmovie;
    }

    public void setIdmovie(Long idmovie) {
        this.idmovie = idmovie;
    }

    @Basic
    @Column(name = "iduser")
    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    private User user;

    @OneToOne
    @JoinColumn(name = "iduser", insertable = false, updatable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
