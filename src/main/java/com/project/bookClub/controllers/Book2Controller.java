package com.project.bookClub.controllers;

import com.project.bookClub.models.Book;
import com.project.bookClub.models.Book1;
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


    @Autowired
    private UserDao userDao;



    @RequestMapping(value = "")
    public String index(Model model, @CookieValue(value = "user", defaultValue = "none") String username) {

        if(username.equals("none")) {
            return "redirect:/user/login";
        }

        User u = userDao.findByUsername(username).get(0);
        model.addAttribute("book2", u.getBook2());
        model.addAttribute("title", "Book #2");

        return "book2/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCommentForm(Model model, @CookieValue(value = "user", defaultValue = "none") String username) {
        if(username.equals("none")) {
            return "redirect:/user/login";
        }
        User u = userDao.findByUsername(username).get(0);
        model.addAttribute("title", "Book #2 Comments");
        model.addAttribute(new Book2());


        return "book2/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCommentForm(
            @ModelAttribute @Valid Book2 newBook2,
            Errors errors,
            Model model , @CookieValue(value = "user", defaultValue = "none") String username) {
        if(username.equals("none")) {
            return "redirect:/user/login";
        }
        User u = userDao.findByUsername(username).get(0);
        if (errors.hasErrors()) {
            model.addAttribute("title", "Book #2 Comments");
            return "book2/add";
        }


        newBook2.setUser(u);
        book2Dao.save(newBook2);
        return "redirect:";
    }





}