package ua.artcode.view;


import ua.artcode.enums.Group_type;
import ua.artcode.enums.Phone_type;
import ua.artcode.exceptions.InvalidNameSurnameException;
import ua.artcode.model.Contact;
import ua.artcode.model.Group;
import ua.artcode.model.Phone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Lisa on 12/12/2016.
 */
public class JTableContacts extends JFrame {

    private ArrayList<Contact> contacts;
    private JTableContactModel tableContactsModel;
    private JScrollPane scrollPaneTable;
    private JScrollPane scrollPaneButtons;
    private JTable jTableContacts;

    private JButton addContactButton = new JButton("add new contact"); // => new frame
    private JButton findContactButton = new JButton("find contact"); // => new frame
    private JButton sortButton = new JButton("sort");
    private JButton cancelButton = new JButton("cancel");
    String[] sortStrings = {"By Name", "By Surname", "By Phone"};

    private JComboBox sortType = new JComboBox (sortStrings);

    public JTableContacts() throws InvalidNameSurnameException {

        contacts = new ArrayList<>();
        contacts.add(new Contact("Eva", "Eva",
                "Kie", "slype", "mail", "1234567890", "Acco12" ));

        setTitle("Contacts");
        //setResizable(false);
        getContentPane().setLayout(new GridBagLayout());
        //setLocationRelativeTo(null);
        setSize(new Dimension(600, 370));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        tableContactsModel = new JTableContactModel(contacts);
        jTableContacts = new JTable(tableContactsModel);
        scrollPaneTable = new JScrollPane(jTableContacts);
        jTableContacts.setPreferredScrollableViewportSize(new Dimension(450, 100));
        getContentPane().add(scrollPaneTable);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 15, 15, 15);

        constraints.fill = GridBagConstraints.BOTH;

        addContactButton.addActionListener(e -> new AddContactFrame());
        //findContactButton.addActionListener(e -> new FindContactFrame());

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
        setVisible(true);


    }
}
