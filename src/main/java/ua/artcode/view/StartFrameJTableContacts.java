package ua.artcode.view;

import ua.artcode.dao.IContactDao;
import ua.artcode.exceptions.InvalidNameSurnameException;
import ua.artcode.model.Contact;
import ua.artcode.utils.FileSaver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Lisa on 12/12/2016.
 */
public class StartFrameJTableContacts extends JFrame {
    // вопрос для ЖЕНИ!!
    // private ArrayList<Contact> contacts;// почему не могу создать List в этом месте?????
    private JTableModel tableModel;
    private JScrollPane scrollPaneTable;
    private JScrollPane scrollPaneButtons;
    private JTable jTableContacts;

    private JButton addContactButton = new JButton("add new contact");
    private JButton findContactButton = new JButton("find contact");
    private JButton sortButton = new JButton("sort");
    private JButton updateButton = new JButton("update");
    //private JButton cancelButton = new JButton("cancel");
    String[] sortStrings = {"By Name", "By Surname", "By Phone"};

    private JComboBox sortType = new JComboBox(sortStrings);

    public StartFrameJTableContacts(ArrayList<Contact> contacts) {
        setTitle("Contacts");
        //setResizable(false);
        getContentPane().setLayout(new GridBagLayout());
        //setLocationRelativeTo(null);
        setSize(new Dimension(600, 370));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        tableModel = new JTableModel(contacts);
        jTableContacts = new JTable(tableModel);
        scrollPaneTable = new JScrollPane(jTableContacts);
        jTableContacts.setPreferredScrollableViewportSize(new Dimension(500, 200));
        getContentPane().add(scrollPaneTable);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 15, 15, 15);

        constraints.fill = GridBagConstraints.BOTH;

       // findContactButton.addActionListener(e -> new FindContactFrame());
       /* updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              JTableModel model = (JTableModel) tableModel.fireTableChanged();
                model.fireTableDataChanged();
               tableModel.fireTableDataChanged();
            }
        });*/

        sortType = new JComboBox(sortStrings);

        JPanel buttonPanel = new JPanel();
        constraints.gridx = 0;
        constraints.gridy = 0;
        buttonPanel.add(addContactButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        buttonPanel.add(findContactButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        buttonPanel.add(updateButton, constraints);


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

        /*updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    contacts.add(new Contact("Vasya", "Pupkin",
                            "Kie", "skype",
                            "mail", "1234567890",
                            "Cell", "123", "BASE"));
                } catch (InvalidNameSurnameException e1) {
                    e1.printStackTrace();
                }
                tableModel.fireTableDataChanged();
            }
        });*/

        //setVisible(true);
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public JTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(JTableModel tableModel) {
        this.tableModel = tableModel;
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
