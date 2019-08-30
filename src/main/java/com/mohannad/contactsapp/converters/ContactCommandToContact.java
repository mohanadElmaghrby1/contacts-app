package com.mohannad.contactsapp.converters;

import com.mohannad.contactsapp.commands.ContactCommand;
import com.mohannad.contactsapp.model.Contact;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * created by mohannad
 */
@Component
public class ContactCommandToContact implements Converter<ContactCommand , Contact> {
    @Override
    public Contact convert(ContactCommand contactCommand) {
        Contact contact = new Contact();
        contact.setUser(contactCommand.getUser());
        contact.setId(contactCommand.getId());
        contact.setPhone(contactCommand.getPhone());
        contact.setEmail(contactCommand.getEmail());
        contact.setFirstName(contactCommand.getFirstName());
        contact.setLastName(contactCommand.getLastName());
        contact.setImage(contactCommand.getImage());
        return contact;
    }
}
