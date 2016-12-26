package ua.artcode.config;

import ua.artcode.contoller.ContactController;
import ua.artcode.dao.ContactDao;
import ua.artcode.dao.IContactDao;
import ua.artcode.utils.FileSaver;

/**
 * Created by Lisa on 12/12/2016.
 */
public class ApplicationContext {
    private String path = ".\\src\\main\\resources\\contacts.txt";
    private FileSaver fileSaver;
    private IContactDao dao;
    private ContactController controller;

    private static final ApplicationContext INSTANCE = new ApplicationContext();

    public static ApplicationContext getInstance(){
        return INSTANCE;
    }

    private ApplicationContext() {
        this.fileSaver = new FileSaver(path);
        this.dao = new ContactDao(fileSaver);
        this.controller = new ContactController(dao);
    }

    public ContactController getController() {
        return controller;
    }

}
