package ua.artcode.view;

import ua.artcode.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Lisa on 12/12/2016.
 */
public class FindContactFrame extends JFrame {

    private ArrayList<Contact> contacts;
    private JLabel insertSearchItem = new JLabel("insert item");
    private JTextField resultText = new JTextField(15);
    private JTextField insertSearchItemText = new JTextField(15);
    private JButton findButton = new JButton("find");

    public FindContactFrame() {

        setTitle("Find contacts");
        setResizable(false);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(600, 400));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 15, 15, 15);

        constraints.fill = GridBagConstraints.BOTH;


        constraints.gridx = 0;
        constraints.gridy = 0;
        add(insertSearchItem, constraints);
        constraints.gridx = 1;
        add(insertSearchItemText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(findButton, constraints);
        constraints.gridx = 1;
        add(resultText, constraints);

        pack();
        setVisible(true);
    }
}
