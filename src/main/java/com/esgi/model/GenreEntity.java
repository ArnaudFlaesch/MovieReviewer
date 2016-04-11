package com.esgi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Arnaud Flaesch on 09/04/2016.
 */
@Entity
@Table(name = "genre", schema = "moviereviewer")
public class GenreEntity {
    private int idgenre;
    private String label;

    @Id
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
