/*
package ua.artcode.contoller;

import ua.artcode.dao.IContactDao;
import ua.artcode.exceptions.InvalidNameSurnameException;
import ua.artcode.model.Contact;
import ua.artcode.view.AddContactFrameTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddContactController {
    private AddContactFrameTest addContactFrame;
    private IContactDao dao;

    public AddContactController(AddContactFrameTest addContactFrame, IContactDao dao) {
        this.addContactFrame = addContactFrame;
        this.dao = dao;


        addContactFrame.getCancelButton().addActionListener(e -> {
            addContactFrame.getContactName().setText("");
            addContactFrame.getSurname().setText("");
            addContactFrame.getAddress().setText("");
            addContactFrame.getGroup().setText("");
            addContactFrame.getSkype().setText("");
            addContactFrame.getMail().setText("");
            addContactFrame.getPhone().setText("");


        });

        addContactFrame.getOkButton().addActionListener(new OkButtonActionListener());

    }

    private class OkButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = addContactFrame.getContactName().getText();
            String surname = addContactFrame.getSurname().getText();
            String address = addContactFrame.getAddress().getText();
            String group = addContactFrame.getGroup().getText();
            String group_type = addContactFrame.getResult_gruop_type().getText();
            String skype = addContactFrame.getSkype().getText();
            String mail = addContactFrame.getMail().getText();
            String phone  = addContactFrame.getPhone().getText();
            String phone_type = addContactFrame.getResult_phone_type().getText();

            Contact contact = null;
            try {
                contact = new Contact(name, surname, address, skype, mail,
                        phone, phone_type, group, group_type);

                boolean result = dao.saveContact(contact);
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
    }

    public void run() {
        addContactFrame.setVisible(true);
    }
}*/
