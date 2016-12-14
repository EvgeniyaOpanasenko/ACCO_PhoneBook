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
        table = new JTableContactModel(contacts);



       // startFrame.getAddContactButton().addActionListener(e -> new AddContactFrameTest());


        startFrame.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.fireTableDataChanged();

            }
        });
        startFrame.getAddContactButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddContactFrameTest addContactFrame = new AddContactFrameTest();
                addContactFrame.getCancelButton().addActionListener(e1 -> {
                    addContactFrame.getContactName().setText("");
                    addContactFrame.getSurname().setText("");
                    addContactFrame.getAddress().setText("");
                    addContactFrame.getGroup().setText("");
                    addContactFrame.getSkype().setText("");
                    addContactFrame.getMail().setText("");
                    addContactFrame.getPhone().setText("");

                });

                addContactFrame.getOkButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = addContactFrame.getContactName().getText();
                        String surname = addContactFrame.getSurname().getText();
                        String address = addContactFrame.getAddress().getText();
                        String group = addContactFrame.getGroup().getText();
                        String group_type = addContactFrame.getResult_gruop_type().getText();
                        String skype = addContactFrame.getSkype().getText();
                        String phone = addContactFrame.getPhone().getText();
                        String mail = addContactFrame.getMail().getText();
                        String phone_type = addContactFrame.getResult_phone_type().getText();


                        try {
                            Contact contact = new Contact(name, surname, address, skype, mail,
                            phone, phone_type, group, group_type);
                            boolean result = dao.saveContact(contact);
                            if (!result){
                                JOptionPane.showMessageDialog(addContactFrame,
                                        "Such contact is already in the list",
                                        "Warning",
                                        JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(addContactFrame,
                                        "Perfect",
                                        "Well done",
                                        JOptionPane.INFORMATION_MESSAGE);

                            }
                        } catch (InvalidNameSurnameException e1) {
                            e1.printStackTrace();
                        }

                    }
                });

            }
        });
        //addContactButton.addActionListener(e -> new AddContactFrame());
        //findContactButton.addActionListener(e -> new FindContactFrame());
    }

    public void run() {
        startFrame.setVisible(true);
    }
}