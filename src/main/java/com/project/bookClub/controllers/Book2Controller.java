package com.project.bookClub.controllers;

import com.project.bookClub.models.Book;
import com.project.bookClub.models.Book2;
import com.project.bookClub.models.User;
import com.project.bookClub.models.data.Book2Dao;
import com.project.bookClub.models.data.BookDao;
import com.project.bookClub.models.data.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("book2")
public class Book2Controller {

    @Autowired
    private Book2Dao book2Dao;


    @RequestMapping(value = "")
    public String index(Model model) {


        Book2 book2 = new Book2();

        book2Dao.save(book2);
        model.addAttribute("book2", book2);
        model.addAttribute("title", "Book #2");

        return "book2/index";
    }



}