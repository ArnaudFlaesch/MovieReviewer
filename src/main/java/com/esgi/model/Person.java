package com.esgi.model;

import lombok.*;

import javax.persistence.*;
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
@Table(name = "person", schema = "moviereviewer")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "idperson")
    private int id;
    private String name;
    private Date birthday;
    private String picture;
    private String linkBo;
    private String nationality;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idperson")
    private Set<Casting> roles = new HashSet<>();

    public Set<Casting> getRoles() {
        return roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    public void setRoles(Set<Casting> roles) {
        this.roles = roles;
    }
   /* @ManyToMany(fetch = FetchType.LAZY, mappedBy = "persons")
    private Set<MovieEntity> movies = new HashSet<MovieEntity>();

    public Set<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(Set<MovieEntity> movies) {
        this.movies = movies;
    }*/
}
