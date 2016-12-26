package ua.artcode.view;

import ua.artcode.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Lisa on 12/12/2016.
 */
public class StartFrameJTableContacts extends JFrame {
    // вопрос для ЖЕНИ!!
//     private ArrayList<Contact> contacts;// почему не могу создать List в этом месте?????
//    Потому что JTableModel не принемает List он заточен под ArrayList
    private JTableModel tableModel;
    private JScrollPane scrollPaneTable;
    private JTable jTableContacts;

    private JButton addContactButton = new JButton("Add new contact");
    private JButton sortButton = new JButton("Sort");
    private String[] sortStrings = {"By Name", "By Surname", "By Group"};

    private JComboBox<String> sortType = new JComboBox<>(sortStrings);

    public StartFrameJTableContacts(ArrayList<Contact> contacts) {
        setTitle("Contacts");
        setResizable(false);
        getContentPane().setLayout(new GridBagLayout());
        setSize(new Dimension(900, 450));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        tableModel = new JTableModel(contacts);
        jTableContacts = new JTable(tableModel);
        jTableContacts.setPreferredScrollableViewportSize(new Dimension(850, 300));
        scrollPaneTable = new JScrollPane(jTableContacts);
        getContentPane().add(scrollPaneTable);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 15, 15, 15);

        constraints.fill = GridBagConstraints.BOTH;

        sortType = new JComboBox<>(sortStrings);

        JPanel buttonPanel = new JPanel();
        constraints.gridx = 0;
        constraints.gridy = 0;
        buttonPanel.add(addContactButton, constraints);


        constraints.gridx = 0;
        constraints.gridy = 3;
        buttonPanel.add(sortButton, constraints);
        constraints.gridx = 1;
        buttonPanel.add(sortType, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(buttonPanel, constraints);
        pack();
    }

    public JButton getAddContactButton() {
        return addContactButton;
    }

    public JButton getSortButton() {
        return sortButton;
    }

    public JComboBox<String> getSortType() {
        return sortType;
    }
}
