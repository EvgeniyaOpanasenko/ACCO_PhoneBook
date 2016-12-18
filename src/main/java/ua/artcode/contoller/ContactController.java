package ua.artcode.contoller;

import ua.artcode.dao.IContactDao;
import ua.artcode.exceptions.InvalidNameSurnameException;
import ua.artcode.model.Contact;
import ua.artcode.view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ContactController {
    private AddContactFrameTest addContactFrame;
    private StartFrameJTableContacts startFrame;
    private AddPhoneNumberFrame addPhoneNumberFrame;
    private FindContactFrame findContactFrame;
    private IContactDao dao;
    private JTableModel tableModel;
    private ArrayList<Contact> contacts;

    public ContactController(StartFrameJTableContacts startFrame, IContactDao dao) {
        this.startFrame = startFrame;
        this.dao = dao;
        //this.tableModel = new JTableModel(contacts);

        startFrame.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


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

                addContactFrame.getAddNewPhoneButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        AddPhoneNumberFrame phoneNumberFrame = new AddPhoneNumberFrame();
                        phoneNumberFrame.getOkButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String number = phoneNumberFrame.getPhone().getText();
                                String phone_type = phoneNumberFrame.getResult_phone_type().getText();
                            }
                        });

                        phoneNumberFrame.getCancelButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                phoneNumberFrame.getPhone().setText("");
                            }
                        });

                    }
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

                        //if (addPhoneNumberFrame.getOkButton().isSelected())


                            try {
                                Contact contact = new Contact(name, surname, address, skype, mail,
                                        phone, phone_type, group, group_type);
                                // the moment when start frame must be updated according to data get out of addContactFrame
                                boolean result = dao.saveContact(contact);
                                //JTableModel model =  tableModel.get


                                if (!result) {
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