package ua.artcode.comparators;

import java.util.Comparator;
import ua.artcode.model.Contact;

/**
 * Created by Yevhen Vorobiei on 26.12.2016.
 */
public class ContactNameComparator implements Comparator<Contact> {
    @Override
    public int compare(Contact contact, Contact anotherContact) {
        return contact.getName().compareTo(anotherContact.getName());
    }
}
