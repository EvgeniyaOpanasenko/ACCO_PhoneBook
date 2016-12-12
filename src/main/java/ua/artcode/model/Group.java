package ua.artcode.model;


import ua.artcode.enums.Group_type;

/**
 * Created by Lisa on 12/4/2016.
 */
public class Group {
    private String group_number;
    private Group_type group_type;

    public Group(String group_number, Group_type group_type) {

        this.group_number = group_number;
        this.group_type = group_type;
    }

}
