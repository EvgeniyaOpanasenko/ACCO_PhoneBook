package demo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by Lisa on 12/12/2016.
 */
public class MyTableModel extends AbstractTableModel {
    ArrayList<Human> humans;

    public MyTableModel(ArrayList<Human> humans) {
        super();
        this.humans = humans;
    }

    @Override
    public int getRowCount() {
        return humans.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }


    @Override
    public String getColumnName(int c) {
        String res = "";
        switch (c) {
            case 0:
                res =  "name";
                break;
            case 1:
                res = "surname";
                break;
            case 2:
                res = "telephone";
            break;
        }
        return res;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return humans.get(r).getName();
            case 1:
                return humans.get(r).getSurname();
            case 2:
                return humans.get(r).getTelephone();
            default:
                return "";
        }
    }
}
