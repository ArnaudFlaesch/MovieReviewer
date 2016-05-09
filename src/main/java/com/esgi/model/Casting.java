package com.esgi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class Entity Person
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "casting")
public class Casting implements Serializable{

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String idmovie;
    @Id
    /*@ManyToOne(targetEntity = Person.class)
    @JoinColumn(name="idperson")*/
    private int idperson;
    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idperson")
    private Person person;

    public void setRole(String role) {
        this.role = role;
    }

    /*public void setId(CastingPk id) {
        this.id = id;
    }

    public void getId() {
        return id;
    }*/
}

