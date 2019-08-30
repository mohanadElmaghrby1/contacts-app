package com.mohannad.contactsapp.services;

import com.mohannad.contactsapp.commands.UserCommand;
import com.mohannad.contactsapp.converters.UserCommandToUser;
import com.mohannad.contactsapp.converters.UserToUserCommand;
import com.mohannad.contactsapp.model.User;
import com.mohannad.contactsapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * created by mohannad
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserToUserCommand userToUserCommand;
    private final UserCommandToUser userCommandToUser;

    public UserServiceImpl(UserRepository userRepository, UserToUserCommand userToUserCommand, UserCommandToUser userCommandToUser) {
        this.userRepository = userRepository;
        this.userToUserCommand = userToUserCommand;
        this.userCommandToUser = userCommandToUser;
    }

    @Override
    public Set<User> getUsers() {
        HashSet<User> set = new HashSet<>();
        userRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public UserCommand saveUserCommand(UserCommand command) {
        User user =userCommandToUser.convert(command);
        userRepository.save(user);
        return userToUserCommand.convert(user);
    }

    @Override
    public UserCommand findCommandById(Long id) {
        UserCommand userCommand = userToUserCommand.convert(userRepository.findById(id).get());
        return userCommand ;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
