package com.esgi.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Class Entity Person
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "idperson")
    private int id;
    private String name;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date birthday;
    private String picture;
    @Column(name = "linkbo")
    private String linkBo;
    private String nationality;

    @OneToMany(fetch = FetchType.LAZY
            ,mappedBy = "idperson"
            //,cascade={CascadeType.PERSIST}
    )
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLinkBo() {
        return linkBo;
    }

    public void setLinkBo(String linkBo) {
        this.linkBo = linkBo;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setRoles(Set<Casting> roles) {
        /*for (Casting role :
                roles) {
            role.setIdperson(this.id);
            role.setIdmovie(UUID.randomUUID().toString()); // TODO : a modifier pour incorporer la relation movies.
        }*/
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
