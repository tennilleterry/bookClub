package com.project.bookClub.controllers;


import com.project.bookClub.models.Book;
import com.project.bookClub.models.Book1;
import com.project.bookClub.models.Comment;
import com.project.bookClub.models.User;
import com.project.bookClub.models.data.Book1Dao;
import com.project.bookClub.models.data.BookDao;
import com.project.bookClub.models.data.CommentDao;
import com.project.bookClub.models.data.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("book1")
public class Book1Controller {

    @Autowired
    private Book1Dao book1Dao;

    @Autowired
    private UserDao userDao;



    @RequestMapping(value = "")
    public String index(Model model, @CookieValue(value = "user", defaultValue = "none") String username) {

        if(username.equals("none")) {
            return "redirect:/user/login";
        }

        User u = userDao.findByUsername(username).get(0);
        model.addAttribute("book1", u.getBook1());
        model.addAttribute("title", "Book #1");

        return "book1/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCommentForm(Model model, @CookieValue(value = "user", defaultValue = "none") String username) {
        if(username.equals("none")) {
            return "redirect:/user/login";
        }
        User u = userDao.findByUsername(username).get(0);
        model.addAttribute("title", "Book #1 Comments");
        model.addAttribute(new Book1());


        return "book1/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCommentForm(
            @ModelAttribute @Valid Book1 newBook1,
            Errors errors,
            Model model , @CookieValue(value = "user", defaultValue = "none") String username) {
        if(username.equals("none")) {
            return "redirect:/user/login";
        }
        User u = userDao.findByUsername(username).get(0);
        if (errors.hasErrors()) {
            model.addAttribute("title", "Book #1 Comments");
            return "book1/add";
        }


        newBook1.setUser(u);
        book1Dao.save(newBook1);
        return "redirect:";
    }





}