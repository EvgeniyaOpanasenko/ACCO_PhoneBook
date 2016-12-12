package demo;

import ua.artcode.exceptions.InvalidNameSurnameException;
import ua.artcode.view.JTableContacts;

/**
 * Created by Lisa on 12/12/2016.
 */
public class Run {
    public static void main(String[] args) throws InvalidNameSurnameException {
        JTableContacts frame = new JTableContacts();
        frame.setVisible(true);
    }
}
