package com.mohannad.contactsapp.model;

import javax.persistence.*;
import java.util.List;

/**
 * created by mohannad
 */
@Entity
@Table(name = "users")
public class User extends Person{

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "user")
    private List<Contact> contacts;

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
