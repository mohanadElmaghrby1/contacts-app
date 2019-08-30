package com.mohannad.contactsapp.repositories;

import com.mohannad.contactsapp.model.Contact;
import org.springframework.data.repository.CrudRepository;

/**
 * created by mohannad
 */
public interface ContactsRepository extends CrudRepository<Contact , Long> {
}
