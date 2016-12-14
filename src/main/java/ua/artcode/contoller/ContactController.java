package ua.artcode.contoller;

import ua.artcode.config.ApplicationContext;
import ua.artcode.dao.ContactDao;
import ua.artcode.dao.IContactDao;
import ua.artcode.exceptions.InvalidNameSurnameException;
import ua.artcode.model.Contact;
import ua.artcode.view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ContactController {
    private AddContactFrameTest addContactFrame;
    private StartFrameJTableContacts startFrame;
    private AddPhoneNumberFrame addPhoneNumberFrame;
    private FindContactFrame findContactFrame;
    private IContactDao dao;
    private JTableContactModel table;
    private List<Contact> contacts;

    public ContactController(StartFrameJTableContacts startFrame, IContactDao dao) {
        this.startFrame = startFrame;
        this.dao = dao;

        contacts = dao.getAllContacts();

    }

    public void run() {
        startFrame.setVisible(true);
    }
}