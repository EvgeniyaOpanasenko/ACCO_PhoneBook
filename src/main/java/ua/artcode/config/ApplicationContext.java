package ua.artcode.config;

import ua.artcode.contoller.ContactController;
import ua.artcode.dao.ContactDao;
import ua.artcode.dao.IContactDao;
import ua.artcode.utils.FileSaver;
import ua.artcode.view.AddContactFrameTest;
import ua.artcode.view.StartFrameJTableContacts;

/**
 * Created by Lisa on 12/12/2016.
 */
public class ApplicationContext {
    private String path = "D:\\ACCO_PhoneBook\\src\\main\\resources\\contacts.txt";
    private FileSaver fileSaver;
    private IContactDao dao;
    private AddContactFrameTest addContactFrame;
    private StartFrameJTableContacts startFrame;
    private ContactController controller;

    private static final ApplicationContext INSTANCE = new ApplicationContext();

    public static ApplicationContext getInstance(){
        return INSTANCE;
    }

    public ApplicationContext() {
        this.fileSaver = new FileSaver(path);
        this.dao = new ContactDao(fileSaver);
        this.startFrame = new StartFrameJTableContacts();
        this.controller = new ContactController(startFrame, dao);
    }

    public ContactController getController() {
        return controller;
    }

}
