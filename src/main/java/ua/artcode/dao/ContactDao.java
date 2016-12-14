package ua.artcode.dao;

import ua.artcode.model.Contact;
import ua.artcode.utils.FileSaver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lisa on 12/12/2016.
 */
public class ContactDao implements IContactDao {
    private FileSaver fileSaver;
    //private List<Contact> contacts;

    public ContactDao(FileSaver fileSaver) {
        this.fileSaver = fileSaver;
        //this.contacts = new ArrayList<>();
        //contacts = fileSaver.read();

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
        ArrayList <Contact> contacts = new ArrayList<>();
        contacts = fileSaver.read();
        return contacts;
    }
// все манипуляции происходят так => выгружаем Лист контактов добавляем\ удаляем \ =>сейвим
   /* public boolean deleteContact (Contact contact){
        if (contacts.contains(contact)){
            contacts.remove(contact);
            return true;
        }else {
            return false;
        }
    }*/
}
