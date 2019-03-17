package com.project.bookClub.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    @ManyToOne
    private User user;



    public Comment(String name) {
        this.name = name;

    }

    public Comment() { }

    public int getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }


    public User getUser() {

        return user;
    }
    public void setUser(User u) {

        this.user = u;
    }




}

