package com.esgi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Class Entity Person
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "casting", schema = "moviereviewer")
public class Casting implements Serializable{

    /*@Id
    public CastingPk id;*/
    @Id
    private String idmovie;
    @Id
    private String idperson;
    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idperson")
    private Person person;

    /*public void setId(CastingPk id) {
        this.id = id;
    }

    public void getId() {
        return id;
    }*/
}

