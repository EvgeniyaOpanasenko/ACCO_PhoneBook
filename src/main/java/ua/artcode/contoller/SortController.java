package ua.artcode.contoller;

import ua.artcode.comparators.ContactGroupComparator;
import ua.artcode.comparators.ContactNameComparator;
import ua.artcode.comparators.ContactSurnameComparator;
import ua.artcode.dao.IContactDao;
import ua.artcode.model.Contact;
import ua.artcode.view.JTableModel;
import ua.artcode.view.StartFrameJTableContacts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Yevhen Vorobiei on 26.12.2016.
 */
public class SortController {
    public SortController(IContactDao dao, StartFrameJTableContacts startFrame) {

        ArrayList<Contact> contacts = dao.getAllContacts();
        switch ((String)startFrame.getSortType().getSelectedItem()){
            case "By Name":
                Collections.sort(contacts, new ContactNameComparator());
                break;
            case "By Surname":
                Collections.sort(contacts, new ContactSurnameComparator());
                break;
            case "By Group":
                Collections.sort(contacts, new ContactGroupComparator());
                break;
        }
        JTableModel tableModel = new JTableModel(contacts);
        JTable jTableContacts = new JTable(tableModel);
        jTableContacts.setPreferredScrollableViewportSize(new Dimension(850, 300));
        JScrollPane scrollPaneTable = new JScrollPane(jTableContacts);
        startFrame.getContentPane().remove(startFrame.getContentPane().getComponent(0));
        startFrame.getContentPane().add(scrollPaneTable, 0);
        startFrame.revalidate();
    }
}
