package com.esgi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CastingPk implements Serializable {
    String idmovie;
    String idperson;

    @Column(name = "idmovie")
    public String getIdMovie() {
        return idmovie;
    }

    public void setIdMovie(String idmovie) {
        this.idmovie = idmovie;
    }

    @Column(name = "idperson")
    public String getidPerson() {
        return idperson;
    }

    public void setidPerson(String idperson) {
        this.idperson = idperson;
    }
}
