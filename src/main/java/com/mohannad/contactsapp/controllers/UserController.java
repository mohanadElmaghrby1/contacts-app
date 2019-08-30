package com.mohannad.contactsapp.controllers;

import com.mohannad.contactsapp.commands.UserCommand;
import com.mohannad.contactsapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by mohannad
 */
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String newRecipe(Model model){
        //create new recipe command and pass it to the view
        //to binding data in
        model.addAttribute("user" , new UserCommand());
        System.out.println("requesteeeeeeed");
        return "user/index";
    }

    @RequestMapping("/home")
    public String homePage(Model model){
        return "index";
    }

    /*handle the post back from /recipe/new */
    @PostMapping //    @RequestMapping(name = "recipe" , method = RequestMethod.POST) is the same
    @RequestMapping("user")
    public String saveOrUpdate(@ModelAttribute UserCommand userCommand){
        //save the returned user command to db
        UserCommand saveUserCommand = userService.saveUserCommand(userCommand);
        System.out.println("user saved successfully "+saveUserCommand);
        //redirect to the recipe show
        return "redirect:/home";
    }

}
