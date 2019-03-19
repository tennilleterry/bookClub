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

    @Size(min = 1, max = 250)
    private String name = "The Girl on The Train";

    @Size(min = 1, max = 250)
    private String author = "Paula Hawkins";

    @Size(min = 1, max = 1000)
    private String description = "Rachel takes the same commuter train every morning and night and stops at the signal " +
            "where she watches the same couple. Their life—as she sees it—is perfect. Not unlike the life she " +
            "recently lost.";

    @OneToMany
    @JoinColumn(name = "book1_id")
    private List<Comment> comments;

    @ManyToOne
    private User user;

    public Book1() { }

    public int getId() {

        return id;
    }

    public String getName() {

        return name;
    }



    public String getAuthor() {

        return author;
    }


    public String getDescription() {

        return description;
    }



    public List<Comment> getComments() {
        return comments;}


    public User getUser() {

        return user;
    }

    public void setUser(User u) {

        this.user = u;
    }

}
