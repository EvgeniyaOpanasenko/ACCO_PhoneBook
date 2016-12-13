package ua.artcode.view;


import ua.artcode.exceptions.InvalidNameSurnameException;
import ua.artcode.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Lisa on 12/12/2016.
 */
public class StartFrameJTableContacts extends JFrame {

    private ArrayList<Contact> contacts;
    private JTableContactModel tableContactsModel;
    private JScrollPane scrollPaneTable;
    private JScrollPane scrollPaneButtons;
    private JTable jTableContacts;

    private JButton addContactButton = new JButton("add new contact");
    private JButton findContactButton = new JButton("find contact");
    private JButton sortButton = new JButton("sort");
    //private JButton cancelButton = new JButton("cancel");
    String[] sortStrings = {"By Name", "By Surname", "By Phone"};

    private JComboBox sortType = new JComboBox (sortStrings);

    public StartFrameJTableContacts()  {

        contacts = new ArrayList<>();
        try {
            contacts.add(new Contact("Eva", "Eva",
                    "Kie", "slype", "mail",
                    "1234567890", "cellPhone",
                    "acco12", "OOP" ));
        } catch (InvalidNameSurnameException e) {
            e.printStackTrace();
        }

        setTitle("Contacts");
        //setResizable(false);
        getContentPane().setLayout(new GridBagLayout());
        //setLocationRelativeTo(null);
        setSize(new Dimension(600, 370));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        tableContactsModel = new JTableContactModel(contacts);
        jTableContacts = new JTable(tableContactsModel);
        scrollPaneTable = new JScrollPane(jTableContacts);
        jTableContacts.setPreferredScrollableViewportSize(new Dimension(500, 200));
        getContentPane().add(scrollPaneTable);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 15, 15, 15);

        constraints.fill = GridBagConstraints.BOTH;

        addContactButton.addActionListener(e -> new AddContactFrameTest());
        //addContactButton.addActionListener(e -> new AddContactFrame());
        findContactButton.addActionListener(e -> new FindContactFrame());


        sortType = new JComboBox(sortStrings);

        JButton btnPress = new JButton("update");
        btnPress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                /*contacts.add(new Contact("Vasya", "Pupkin",
                        "Kie", "slype",
                        "mail", "1234567890", "Acco12" ));*/
                tableContactsModel.fireTableDataChanged();
            }
        });

        JPanel buttonPanel = new JPanel();
        constraints.gridx = 0;
        constraints.gridy = 0;
        buttonPanel.add(addContactButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        buttonPanel.add(findContactButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        buttonPanel.add(btnPress, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        buttonPanel.add(findContactButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        buttonPanel.add(sortButton, constraints);
        constraints.gridx = 1;
        buttonPanel.add(sortType, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(buttonPanel, constraints);

        //Отображаем контейнер
        //setVisible(true);
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public JTableContactModel getTableContactsModel() {
        return tableContactsModel;
    }

    public void setTableContactsModel(JTableContactModel tableContactsModel) {
        this.tableContactsModel = tableContactsModel;
    }

    public JButton getAddContactButton() {
        return addContactButton;
    }

    public void setAddContactButton(JButton addContactButton) {
        this.addContactButton = addContactButton;
    }

    public JButton getFindContactButton() {
        return findContactButton;
    }

    public void setFindContactButton(JButton findContactButton) {
        this.findContactButton = findContactButton;
    }

    public JButton getSortButton() {
        return sortButton;
    }

    public void setSortButton(JButton sortButton) {
        this.sortButton = sortButton;
    }

    public String[] getSortStrings() {
        return sortStrings;
    }

    public void setSortStrings(String[] sortStrings) {
        this.sortStrings = sortStrings;
    }

    public JComboBox getSortType() {
        return sortType;
    }

    public void setSortType(JComboBox sortType) {
        this.sortType = sortType;
    }
}
