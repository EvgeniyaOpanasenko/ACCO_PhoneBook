package ua.artcode.contoller;

import ua.artcode.dao.IContactDao;
import ua.artcode.exceptions.InvalidNameSurnameException;
import ua.artcode.model.Contact;
import ua.artcode.view.AddContactFrameTest;
import ua.artcode.view.JTableContactModel;
import ua.artcode.view.StartFrameJTableContacts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ContactController {
    private AddContactFrameTest addContactFrame;
    private StartFrameJTableContacts startFrame;
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