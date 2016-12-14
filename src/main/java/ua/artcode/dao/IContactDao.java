package ua.artcode.dao;

import ua.artcode.model.Contact;

import java.util.ArrayList;

/**
 * Created by Lisa on 12/12/2016.
 */
public interface IContactDao {
    boolean saveContact(Contact contact);
    ArrayList<Contact> getAllContacts();
}
