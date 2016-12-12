package ua.artcode.dao;

import ua.artcode.model.Contact;
import ua.artcode.utils.FileSaver;
import ua.artcode.view.AddContactFrameTest;

import java.util.List;

/**
 * Created by Lisa on 12/12/2016.
 */
public class ContactDao implements IContactDao {
    private FileSaver fileSaver;
    private List<Contact> contacts;

    public ContactDao(FileSaver fileSaver) {
        this.fileSaver = fileSaver;

    }

    @Override
    public boolean saveContact(Contact contact) {
        contacts = fileSaver.read();
        if(!contacts.contains(contact)){
            contacts.add(contact);
            fileSaver.save(contacts);
            return true;
        }
        return false;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contacts = fileSaver.read();
    }

    public boolean deleteContact (Contact contact){
        if (contacts.contains(contact)){
            contacts.remove(contact);
            return true;
        }else {
            return false;
        }
    }
}
