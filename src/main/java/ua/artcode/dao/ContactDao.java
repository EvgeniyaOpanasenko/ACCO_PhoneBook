package ua.artcode.dao;

import ua.artcode.model.Contact;
import ua.artcode.utils.FileSaver;

import java.util.ArrayList;

/**
 * Created by Lisa on 12/12/2016.
 */
public class ContactDao implements IContactDao {
    private FileSaver fileSaver;

    public ContactDao(FileSaver fileSaver) {
        this.fileSaver = fileSaver;
    }

    @Override
    public boolean saveContact(Contact contact) {
        ArrayList <Contact> contacts;
        contacts = fileSaver.read();
        if(!contacts.contains(contact)){
            contacts.add(contact);
            fileSaver.save(contacts);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Contact> getAllContacts() {
        return fileSaver.read();
    }
// все манипуляции происходят так => выгружаем Лист контактов добавляем\ удаляем \ =>сейвим
    @Override
    public boolean deleteContact (Contact contact){
        ArrayList <Contact> contacts;
        contacts = fileSaver.read();
        if(!contacts.contains(contact)){
            contacts.remove(contact);
            fileSaver.save(contacts);
            return true;
        }
        return false;
    }

    @Override
    public Contact findContact(Contact contact) {
//        TODO
        return null;
    }

    @Override
    public boolean updateContact(Contact contact) {
//        TODO
        return false;
    }
}
