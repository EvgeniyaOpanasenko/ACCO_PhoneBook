package ua.artcode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lisa on 12/9/2016.
 */
public class AddPhoneNumberFrame extends JFrame {
    private JTextField phone = new JTextField(15);
    private JTextField skype = new JTextField(15);
    private JTextField mail = new JTextField(15);

    private JLabel phoneLabel = new JLabel("phone");
    private JLabel skypeLabel = new JLabel("skype");
    private JLabel mailLabel = new JLabel("mail");

    private JButton okButton = new JButton("OK");
    private JButton cancelButton = new JButton("cancel");

    String[] phoneStrings = {"CELL_PHONE", "WORK_PHONE", "HOME_PHONE"};

    private JComboBox phone_type = new JComboBox(phoneStrings);

    private JTextField result_phone_type = new JTextField(15);

    public AddPhoneNumberFrame() {
        phone_type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox combox = (JComboBox) e.getSource();
                String choice = (String) combox.getSelectedItem();
                result_phone_type.setText(String.valueOf(choice));

            }
        });
        setTitle("Add Phone");
        setResizable(false);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(600, 400));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 15, 15, 15);

        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 0;
        constraints.gridy = 9;
        add(phoneLabel, constraints);
        constraints.gridx = 1;
        add(phone, constraints);
        constraints.gridx = 2;
        add(phone_type, constraints);

        constraints.gridx = 0;
        constraints.gridy = 11;
        add(okButton, constraints);
        constraints.gridx = 1;
        add(cancelButton, constraints);

        pack();
        setVisible(true);
    }

    public JTextField getPhone() {
        return phone;
    }

    public JComboBox getPhone_type() {
        return phone_type;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JTextField getResult_phone_type() {
        return result_phone_type;
    }
}
