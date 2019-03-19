package com.project.bookClub.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Book2 {

    @Id
    @GeneratedValue
    private int id;


    @NotNull
    @Size(min = 1, max = 250)
    private String comment;


    @ManyToOne
    private User user;

    public Book2() { }

    public Book2(String comment){
        this.comment = comment;
    }

    public int getId() {

        return id;
    }

    public String getComment() {

        return comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }


    public User getUser() {

        return user;
    }

    public void setUser(User u) {

        this.user = u;
    }
}