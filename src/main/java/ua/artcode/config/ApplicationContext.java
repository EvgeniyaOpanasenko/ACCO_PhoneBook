package ua.artcode.config;

import ua.artcode.contoller.ContactController;
import ua.artcode.dao.ContactDao;
import ua.artcode.dao.IContactDao;
import ua.artcode.utils.FileSaver;
import ua.artcode.view.AddContactFrameTest;

/**
 * Created by Lisa on 12/12/2016.
 */
public class ApplicationContext {
    private String path = "D:\\ACCO_PhoneBook\\src\\main\\resources\\contacts.txt";
    private FileSaver fileSaver;
    private IContactDao dao;
    private AddContactFrameTest addContactFrame;
    private ContactController controller;

    private static final ApplicationContext INSTANCE = new ApplicationContext();

    public static ApplicationContext getInstance(){
        return INSTANCE;
    }

    public ApplicationContext() {
        this.fileSaver = new FileSaver(path);
        this.dao = new ContactDao(fileSaver);
        this.addContactFrame = new AddContactFrameTest();
        this.controller = new ContactController(addContactFrame, dao);
    }

    public ContactController getController() {
        return controller;
    }

}
