package com.esgi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import lombok.*;
/**
 * Created by hideo on 02/04/16.
 */


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

    @Column(name="password")
    private String password;

    @Column(name="creation_Date")
    private Date creation_Date;

    @Column(name="age")
    private int age;

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

    public Date getCreation_Date() {
        return creation_Date;
    }

    public void setCreation_Date(Date creation_Date) {
        this.creation_Date = creation_Date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
