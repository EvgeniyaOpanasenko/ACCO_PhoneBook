package ua.artcode.contoller;

import ua.artcode.dao.IContactDao;
import ua.artcode.model.Contact;
import ua.artcode.view.*;

import java.util.ArrayList;

public class ContactController {
    private StartFrameJTableContacts startFrame;
    private ArrayList<Contact> contacts;

    public ContactController(IContactDao dao) {
        this.contacts = new ArrayList<>(dao.getAllContacts());
        this.startFrame = new StartFrameJTableContacts(contacts);

        startFrame.getUpdateButton().addActionListener(e -> {
//          TODO
        });

        startFrame.getAddContactButton().addActionListener(e -> {
           new AddContactController(dao, startFrame);
        });
    }

    public void run() {
        startFrame.setVisible(true);
    }
}