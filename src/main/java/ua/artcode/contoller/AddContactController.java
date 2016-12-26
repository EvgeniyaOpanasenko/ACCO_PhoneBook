package ua.artcode.contoller;

import ua.artcode.dao.IContactDao;
import ua.artcode.exceptions.InvalidNameSurnameException;
import ua.artcode.model.Contact;
import ua.artcode.view.AddContactFrame;
import ua.artcode.view.JTableModel;
import ua.artcode.view.StartFrameJTableContacts;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Yevhen Vorobiei on 20.12.2016.
 */
public class AddContactController {

    public AddContactController(IContactDao dao, StartFrameJTableContacts startFrame) {
        AddContactFrame addContactFrame = new AddContactFrame();

        addContactFrame.getOkButton().addActionListener(e -> {
            String name = addContactFrame.getContactName().getText();
            String surname = addContactFrame.getSurname().getText();
            String address = addContactFrame.getAddress().getText();
            String group = addContactFrame.getGroup().getText();
            String groupType = (String) addContactFrame.getGroupType().getSelectedItem();
            String skype = addContactFrame.getSkype().getText();
            String phone = addContactFrame.getPhone().getText();
            String mail = addContactFrame.getMail().getText();
            String phoneType = (String) addContactFrame.getPhoneType().getSelectedItem();

            try {
                Contact contact = new Contact(name, surname, address, skype, mail,
                        phone, phoneType, group, groupType);
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

                    JTableModel tableModel = new JTableModel(dao.getAllContacts());
                    JTable jTableContacts = new JTable(tableModel);
                    jTableContacts.setPreferredScrollableViewportSize(new Dimension(850, 300));
                    JScrollPane scrollPaneTable = new JScrollPane(jTableContacts);
                    startFrame.getContentPane().remove(startFrame.getContentPane().getComponent(0));
                    startFrame.getContentPane().add(scrollPaneTable, 0);
                    startFrame.revalidate();
                    addContactFrame.dispose();
                }
            } catch (InvalidNameSurnameException ex) {
                JOptionPane.showMessageDialog(addContactFrame,
                        "Must start from capital letter, contain only letters.\n" +
                                "Size 2 - 15 letters",
                        ex.getMessage(),
                        JOptionPane.ERROR_MESSAGE);
            }
        });

    }
}
