package ua.artcode.model;


import ua.artcode.enums.GroupType;

/**
 * Created by Lisa on 12/4/2016.
 */
public class Group {
    private String groupNumber;
    private GroupType groupType;

    public Group(String groupNumber, GroupType groupType) {

        this.groupNumber = groupNumber;
        this.groupType = groupType;
    }

}
