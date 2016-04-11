package com.esgi.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Arnaud Flaesch on 09/04/2016.
 */
@Entity
@Table(name = "genre", schema = "moviereviewer")
public class GenreEntity {
    private int idgenre;
    private String label;

    @Id
    @GeneratedValue
    @Column(name = "idgenre")
    public int getIdgenre() {
        return idgenre;
    }

    public void setIdgenre(int idgenre) {
        this.idgenre = idgenre;
    }

    @Basic
    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
