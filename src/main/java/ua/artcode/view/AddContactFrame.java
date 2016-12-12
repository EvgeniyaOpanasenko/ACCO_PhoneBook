package ua.artcode.view;

import javax.swing.*;
import java.awt.*;

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

    private JLabel nameLabel = new JLabel("name");
    private JLabel surnameLabel = new JLabel("surname");
    private JLabel addressLabel = new JLabel("address");
    private JLabel groupLabel = new JLabel("grup");
    private JLabel phoneLabel = new JLabel("phone");
    private JLabel skypeLabel = new JLabel("skype");
    private JLabel mailLabel = new JLabel("mail");

    private JButton addNewPhoneButton = new JButton("add phone number");
    private JButton okButton = new JButton("OK");
    private JButton cancelButton = new JButton("cancel");

    String[] phoneStrings = {"CELL_PHONE", "WORK_PHONE", "HOME_PHONE"};
    String[] groupStrings = {"BASE", "OOP", "PROF"};

    private JComboBox phone_type = new JComboBox(phoneStrings);
    private JComboBox group_type = new JComboBox(groupStrings);

    public AddContactFrame() {

        setTitle("Contacts");
        setResizable(false);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(600, 400));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 15, 15, 15);

        constraints.fill = GridBagConstraints.BOTH;

        //addNewPhoneButton.addActionListener(e -> new AddPhoneNumberFrame());

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
        add(group_type, constraints);

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
        constraints.gridy = 10;
        add(addNewPhoneButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 11;
        add(okButton, constraints);
        constraints.gridx = 1;
        add(cancelButton, constraints);

        pack();
        setVisible(true);
    }

}
