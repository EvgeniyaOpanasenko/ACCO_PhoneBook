package ua.artcode.contoller;

import ua.artcode.dao.IContactDao;
import ua.artcode.model.Contact;
import ua.artcode.view.StartFrameJTableContacts;

import java.util.ArrayList;

public class ContactController {
    private StartFrameJTableContacts startFrame;

    public ContactController(IContactDao dao) {
        ArrayList<Contact> contacts = new ArrayList<>(dao.getAllContacts());
        this.startFrame = new StartFrameJTableContacts(contacts);

        startFrame.getAddContactButton().addActionListener(e -> {
           new AddContactController(dao, startFrame);
        });

        startFrame.getSortButton().addActionListener(e -> new SortController(dao, startFrame));
    }

    public void run() {
        startFrame.setVisible(true);
    }
}