package com.mohannad.contactsapp.bootstrap;

import com.mohannad.contactsapp.model.Contact;
import com.mohannad.contactsapp.model.User;
import com.mohannad.contactsapp.repositories.ContactsRepository;
import com.mohannad.contactsapp.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;
import java.util.ArrayList;

/**
 * created by mohannad
 */
@Component
public class ContactsBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;
    private ContactsRepository contactsRepository;

    public ContactsBootstrap(UserRepository userRepository, ContactsRepository contactsRepository) {
        this.userRepository = userRepository;
        this.contactsRepository = contactsRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //create user
        User user = new User();
        user.setEmail("mohannad.elmaghrby@gmail.com");
        user.setFirstName("mohannad");
        user.setLastName("Elmaghrby");
        user.setPhone("01014152062");

        //create contacts
        Contact momoContact =new Contact();
        momoContact.setFirstName("momo");
        momoContact.setLastName("hamdy");
        momoContact.setEmail("momo@gmail.com");
        momoContact.setPhone("01005087893");
        momoContact.setUser(user);

        //create contacts
        Contact sosoContact =new Contact();
        sosoContact.setFirstName("soso");
        sosoContact.setLastName("nady");
        sosoContact.setEmail("soso@gmail.com");
        sosoContact.setPhone("010050878932");
        sosoContact.setUser(user);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(momoContact);
        contacts.add(sosoContact);

        user.setContacts(contacts);

        userRepository.save(user);
    }
}
