package com.mohannad.contactsapp.controllers;

/**
 * created by mohannad  on 13/09/19
 */

import com.mohannad.contactsapp.commands.UserCommand;
import com.mohannad.contactsapp.model.User;
import com.mohannad.contactsapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController  {

    private final UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/home")
    public String homePage(Model model){
        User user =userService.findById(1l);
        model.addAttribute("contacts" , user.getContacts());
        return "index";
    }
}
