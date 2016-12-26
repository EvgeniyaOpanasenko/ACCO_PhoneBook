package ua.artcode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lisa on 12/12/2016.
 */
public class AddContactFrame extends JFrame {
    private JTextField name = new JTextField(15);
    private JTextField surname = new JTextField(15);
    private JTextField address = new JTextField(15);
    private JTextField group = new JTextField(15);
    private JTextField phone = new JTextField(15);
    private JTextField skype = new JTextField(15);
    private JTextField mail = new JTextField(15);

    private JLabel nameLabel = new JLabel("Name");
    private JLabel surnameLabel = new JLabel("Surname");
    private JLabel addressLabel = new JLabel("Address");
    private JLabel groupLabel = new JLabel("Group");
    private JLabel phoneLabel = new JLabel("Phone");
    private JLabel skypeLabel = new JLabel("Skype");
    private JLabel mailLabel = new JLabel("Email");

    private JButton okButton = new JButton("OK");
    private JButton cancelButton = new JButton("Cancel");

    private final String[] phoneLabels = {"<make choice>", "CELL_PHONE", "WORK_PHONE", "HOME_PHONE"};
    private final String[] groupLabels = {"<make choice>", "BASE", "OOP", "PROF"};

    private JComboBox<String> phoneType = new JComboBox<>(phoneLabels);
    private JComboBox<String> groupType = new JComboBox<>(groupLabels);

    public AddContactFrame() {

        cancelButton.addActionListener(e -> {
            name.setText("");
            surname.setText("");
            address.setText("");
            group.setText("");
            skype.setText("");
            mail.setText("");
            phone.setText("");
//            TODO refresh comboBox
        });


        setTitle("Add contact");
        setResizable(false);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(600, 400));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        constraints.fill = GridBagConstraints.BOTH;


        constraints.gridx = 0;
        constraints.gridy = 0;
        add(nameLabel, constraints);

        constraints.gridx = 1;
        add(name, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(surnameLabel, constraints);

        constraints.gridx = 1;
        add(surname, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        add(addressLabel, constraints);

        constraints.gridx = 1;
        add(address, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        add(groupLabel, constraints);

        constraints.gridx = 1;
        add(group, constraints);

        constraints.gridx = 2;
        add(groupType, constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        add(skypeLabel, constraints);

        constraints.gridx = 1;
        add(skype, constraints);

        constraints.gridx = 0;
        constraints.gridy = 8;
        add(mailLabel, constraints);

        constraints.gridx = 1;
        add(mail, constraints);

        constraints.gridx = 0;
        constraints.gridy = 9;
        add(phoneLabel, constraints);

        constraints.gridx = 1;
        add(phone, constraints);

        constraints.gridx = 2;
        add(phoneType, constraints);

        constraints.fill = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 11;
        add(okButton, constraints);

        constraints.gridx = 1;
        add(cancelButton, constraints);

        pack();
        setVisible(true);
    }

    public JComboBox<String> getPhoneType() {
        return phoneType;
    }

    public JComboBox<String> getGroupType() {
        return groupType;
    }

    public JTextField getContactName() {
        return name;
    }

    public JTextField getSurname() {
        return surname;
    }

    public JTextField getAddress() {
        return address;
    }

    public JTextField getGroup() {
        return group;
    }

    public JTextField getPhone() {
        return phone;
    }

    public JTextField getSkype() {
        return skype;
    }

    public JTextField getMail() {
        return mail;
    }

    public JButton getOkButton() {
        return okButton;
    }

}

