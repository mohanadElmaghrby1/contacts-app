package com.mohannad.contactsapp.converters;

import com.mohannad.contactsapp.commands.UserCommand;
import com.mohannad.contactsapp.model.User;
import org.springframework.core.convert.converter.Converter;

/**
 * created by mohannad
 */
public class UserToUserCommand implements Converter<User , UserCommand> {
    @Override
    public UserCommand convert(User user) {
        UserCommand userCommand = new UserCommand();
        userCommand.setContacts(user.getContacts());
        userCommand.setId(user.getId());
        userCommand.setPhone(user.getPhone());
        userCommand.setEmail(user.getEmail());
        userCommand.setFirstName(user.getFirstName());
        userCommand.setLastName(user.getLastName());
        userCommand.setImage(user.getImage());
        return userCommand;
    }
}