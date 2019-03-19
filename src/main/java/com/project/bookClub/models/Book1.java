package com.project.bookClub.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class Book1 {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 1, max = 250)
    private String comment;


    @ManyToOne
    private User user;

    public Book1() { }

    public Book1(String comment) {
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
