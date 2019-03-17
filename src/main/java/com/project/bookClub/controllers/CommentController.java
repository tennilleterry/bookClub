package com.project.bookClub.controllers;

import com.project.bookClub.models.Comment;
import com.project.bookClub.models.User;
import com.project.bookClub.models.data.CommentDao;
import com.project.bookClub.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "")
    public String index(Model model, @CookieValue(value = "user", defaultValue = "none") String username) {

        if(username.equals("none")) {
            return "redirect:/user/login";
        }

        User u = userDao.findByUsername(username).get(0);
        model.addAttribute("comments", u.getComments());
        model.addAttribute("title", "Book Club - Forum");

        return "comment/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddBookForm(Model model, @CookieValue(value = "user", defaultValue = "none") String username) {
        if(username.equals("none")) {
            return "redirect:/user/login";
        }
        User u = userDao.findByUsername(username).get(0);
        model.addAttribute("title", "Add comment");
        model.addAttribute(new Comment());


        return "comment/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCommentForm(
            @ModelAttribute @Valid Comment newComment,
            Errors errors,
            Model model , @CookieValue(value = "user", defaultValue = "none") String username) {
        if(username.equals("none")) {
            return "redirect:/user/login";
        }
        User u = userDao.findByUsername(username).get(0);
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add comment");
            return "comment/add";
        }


        newComment.setUser(u);
        commentDao.save(newComment);
        return "redirect:";
    }


}