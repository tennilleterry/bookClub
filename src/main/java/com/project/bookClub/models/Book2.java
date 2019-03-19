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

    @Size(min = 1, max = 250)
    private String name = "The Silent Patient";

    @Size(min = 1, max = 250)
    private String author = "Alex Michaelides";

    @Size(min = 1, max = 1000)
    private String description = "Late one evening, Alicia shoots Gabriel five times and then never speaks another " +
            "word. The Silent Patient is a heart-stopping debut thriller about a woman's brutal and " +
            "random act of violence against her husband - and the man obsessed with discovering why.";


    public Book2() {
    }

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
}