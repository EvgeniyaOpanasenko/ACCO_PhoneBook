package ua.artcode.comparators;

import ua.artcode.model.Contact;

import java.util.Comparator;

/**
 * Created by Yevhen Vorobiei on 26.12.2016.
 */
public class ContactSurnameComparator implements Comparator<Contact> {
    @Override
    public int compare(Contact contact, Contact anotherContact) {
        return contact.getSurname().compareTo(anotherContact.getSurname());
    }
}
