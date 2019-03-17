package com.project.bookClub.controllers;

import com.project.bookClub.models.Comment;
import com.project.bookClub.models.User;
import com.project.bookClub.models.data.CommentDao;
import com.project.bookClub.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "")
public class HomeController {

    @Autowired
    CommentDao commentDao;
    UserDao userDao;


    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("comments", commentDao.findAll());
        //model.addAttribute("users", userDao.findAll());

        model.addAttribute("title", "Online Book Club");
        return "index";
    }

}