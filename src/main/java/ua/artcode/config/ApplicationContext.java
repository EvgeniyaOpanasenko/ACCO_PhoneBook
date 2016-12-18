package ua.artcode.config;

import ua.artcode.contoller.ContactController;
import ua.artcode.dao.ContactDao;
import ua.artcode.dao.IContactDao;
import ua.artcode.model.Contact;
import ua.artcode.utils.FileSaver;
import ua.artcode.view.AddContactFrameTest;
import ua.artcode.view.JTableModel;
import ua.artcode.view.StartFrameJTableContacts;

import java.util.ArrayList;

/**
 * Created by Lisa on 12/12/2016.
 */
public class ApplicationContext {
    private String path = "D:\\ACCO_PhoneBook\\src\\main\\resources\\contacts.txt";
    private FileSaver fileSaver;
    private IContactDao dao;
    private StartFrameJTableContacts startFrame;
    private ContactController controller;
    private ArrayList<Contact> contacts;

    private static final ApplicationContext INSTANCE = new ApplicationContext();

    public static ApplicationContext getInstance(){
        return INSTANCE;
    }

    public ApplicationContext() {
        this.fileSaver = new FileSaver(path);
        this.dao = new ContactDao(fileSaver);
        this.contacts = new ArrayList<>(dao.getAllContacts());
        this.startFrame = new StartFrameJTableContacts(contacts);
        this.controller = new ContactController(startFrame, dao);

    }

    public ContactController getController() {
        return controller;
    }

}
