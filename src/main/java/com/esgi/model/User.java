package com.esgi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
/**
 * Created by hideo on 02/04/16.
 */

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class User {
    @GeneratedValue
    @Id
    private long id;

    @Column(name="name")
    private String name;

    //@Column(pseudo="pseudo")
    //private String pseudo;

    @Column(name="password")
    private String password;

    @Column(name="age")
    private int age;

    public User(String name,String password,int age){
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
