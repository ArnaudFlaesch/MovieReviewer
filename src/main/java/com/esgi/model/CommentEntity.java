package com.esgi.model;

import javax.persistence.*;

/**
 * Created by Arnaud on 14/04/2016.
 */
@Entity
@Table(name = "commentaires", schema = "moviereviewer")
public class CommentEntity {
    private int idCommentaire;
    private String comment;

    @Id
    @GeneratedValue
    @Column(name = "idcommentaire")
    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
}
