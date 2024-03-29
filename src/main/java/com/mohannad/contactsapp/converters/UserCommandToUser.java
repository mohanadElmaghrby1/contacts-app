package com.mohannad.contactsapp.converters;

import com.mohannad.contactsapp.commands.ContactCommand;
import com.mohannad.contactsapp.commands.UserCommand;
import com.mohannad.contactsapp.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * created by mohannad
 */
@Component
public class UserCommandToUser implements Converter<UserCommand , User> {
    @Override
    public User convert(UserCommand userCommand ){
        User user = new User();
        user.setPassword(userCommand.getPassword());
        user.setContacts(userCommand.getContacts());
        user.setId(userCommand.getId());
        user.setPhone(userCommand.getPhone());
        user.setEmail(userCommand.getEmail());
        user.setFirstName(userCommand.getFirstName());
        user.setLastName(userCommand.getLastName());
        user.setImage(userCommand.getImage());
        return user;
    }
}
