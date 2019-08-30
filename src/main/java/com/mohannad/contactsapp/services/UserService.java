package com.mohannad.contactsapp.services;

import com.mohannad.contactsapp.commands.UserCommand;
import com.mohannad.contactsapp.model.User;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * created by mohannad
 */
public interface UserService {
    Set<User> getUsers();
    User findById(Long id);
    UserCommand saveUserCommand(UserCommand command);
    UserCommand findCommandById(Long id);
    void deleteById(Long id);
}
