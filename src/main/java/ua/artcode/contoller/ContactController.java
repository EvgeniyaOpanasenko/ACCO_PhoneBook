package ua.artcode.contoller;

import ua.artcode.dao.IContactDao;
import ua.artcode.exceptions.InvalidNameSurnameException;
import ua.artcode.model.Contact;
import ua.artcode.model.Group;
import ua.artcode.model.Phone;
import ua.artcode.view.AddContactFrameTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lisa on 12/12/2016.
 */
public class ContactController {
    private AddContactFrameTest addContactFrame;
    private IContactDao dao;

    public ContactController(AddContactFrameTest addContactFrame, IContactDao dao) {
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
            String group_type = addContactFrame.getGroup_type().getActionCommand();
            String skype = addContactFrame.getSkype().getText();
            String mail = addContactFrame.getMail().getText();
            String phone  = addContactFrame.getPhone().getText();
            String phone_type = addContactFrame.getPhone_type().getActionCommand();

            Contact contact = null;
            try {
                contact = new Contact(name, surname, address, skype, mail,
                        phone.concat(phone_type), group.concat(group_type));
            } catch (InvalidNameSurnameException e1) {
                e1.printStackTrace();
            }

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


        }
    }

    public void run() {
        addContactFrame.setVisible(true);
    }
}
