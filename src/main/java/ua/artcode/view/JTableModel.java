package ua.artcode.view;

import ua.artcode.model.Contact;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by Lisa on 12/12/2016.
 */
public class JTableModel extends AbstractTableModel  {
    private ArrayList<Contact> contacts;

    public JTableModel(ArrayList<Contact> contacts) {
        super();
        this.contacts = contacts;
    }

   /*   TODO
   public void refresh() {
        contacts = new ArrayList<>(dao.getAllContacts());
        fireTableDataChanged();
    }*/

    @Override
    public int getRowCount() {
        return contacts.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    //setting data to each cell
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return contacts.get(rowIndex).getName();
            case 1:
                return contacts.get(rowIndex).getSurname();
            case 2:
                return contacts.get(rowIndex).getAddress();
            case 3:
                return contacts.get(rowIndex).getGroup();
            case 4:
                return contacts.get(rowIndex).getGroupType();
            case 5:
                return contacts.get(rowIndex).getSkype();
            case 6:
                return contacts.get(rowIndex).getMail();
            case 7:
                return contacts.get(rowIndex).getPhone();
            case 8:
                return contacts.get(rowIndex).getPhoneType();

            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        String res = "";

        switch (column) {
            case 0:
                res = "Name";
                break;
            case 1:
                res = "Last Name";
                break;
            case 2:
                res = "Address";
                break;
            case 3:
                res = "Group";
                break;
            case 4:
                res = "Group type";
                break;
            case 5:
                res = "Skype";
                break;
            case 6:
                res = "Mail";
                break;
            case 7:
                res = "Number";
                break;
            case 8:
                res = "Phone type";
                break;
        }
        return res;
    }

}
