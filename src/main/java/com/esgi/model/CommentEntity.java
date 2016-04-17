package com.esgi.model;

import javax.persistence.*;

/**
 * Created by Arnaud on 14/04/2016.
 */
@Entity
@Table(name = "comment", schema = "moviereviewer")
public class CommentEntity {
    private Long idComment;
    private String comment;
    private Long idmovie;

    @Id
    @GeneratedValue
    @Column(name = "idcomment")
    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
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

    private User user;

    @OneToOne
    @JoinColumn(name = "iduser")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
