package com.esgi.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Arnaud Flaesch on 15/04/2016.
 */
public class ReviewEntityPK implements Serializable {

    private Long idmovie;
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
}
