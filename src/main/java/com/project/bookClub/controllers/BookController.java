package com.project.bookClub.controllers;


import com.project.bookClub.models.Book;
import com.project.bookClub.models.User;
import com.project.bookClub.models.data.BookDao;
import com.project.bookClub.models.data.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "")
    public String index(Model model, @CookieValue(value = "user", defaultValue = "none") String username) {

        if(username.equals("none")) {
            return "redirect:/user/login";
        }

        User u = userDao.findByUsername(username).get(0);
        model.addAttribute("books", u.getBooks());
        model.addAttribute("title", "My Books");

        return "book/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddBookForm(Model model, @CookieValue(value = "user", defaultValue = "none") String username) {
        if(username.equals("none")) {
            return "redirect:/user/login";
        }
        User u = userDao.findByUsername(username).get(0);
        model.addAttribute("title", "Add Book");
        model.addAttribute(new Book());


        return "book/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddBookForm(
            @ModelAttribute @Valid Book newBook,
            Errors errors,
            Model model , @CookieValue(value = "user", defaultValue = "none") String username) {
        if(username.equals("none")) {
            return "redirect:/user/login";
        }
        User u = userDao.findByUsername(username).get(0);
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Book");
            return "book/add";
        }


        newBook.setUser(u);
        bookDao.save(newBook);
        return "redirect:";
    }


}