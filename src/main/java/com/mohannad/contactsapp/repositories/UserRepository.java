package com.mohannad.contactsapp.repositories;

import com.mohannad.contactsapp.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * created by mohannad
 */
public interface UserRepository extends CrudRepository<User , Long> {
}
