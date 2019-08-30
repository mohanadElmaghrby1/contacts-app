package com.mohannad.contactsapp.converters;

import com.mohannad.contactsapp.commands.ContactCommand;
import com.mohannad.contactsapp.model.Contact;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * created by mohannad
 */
@Component
public class ContactToContactCommand implements Converter<Contact , ContactCommand> {

    @Override
    public ContactCommand convert(Contact contact) {
        ContactCommand contactCommand = new ContactCommand();
        contactCommand.setUser(contact.getUser());
        contactCommand.setId(contact.getId());
        contactCommand.setPhone(contact.getPhone());
        contactCommand.setEmail(contact.getEmail());
        contactCommand.setFirstName(contact.getFirstName());
        contactCommand.setLastName(contact.getLastName());
        contactCommand.setImage(contact.getImage());
        return contactCommand;
    }
}
