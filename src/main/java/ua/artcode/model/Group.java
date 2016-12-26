package ua.artcode.model;


import ua.artcode.enums.GroupType;

/**
 * Created by Lisa on 12/4/2016.
 */
public class Group implements Comparable<Group> {
    private int groupNumber;
    private GroupType groupType;

    public Group(int groupNumber, GroupType groupType) {

        this.groupNumber = groupNumber;
        this.groupType = groupType;
    }

    @Override
    public int compareTo(Group group) {
        int typeResult = this.groupType.compareTo(group.groupType);
        if(typeResult == 0) return typeResult;
        return this.groupNumber - group.groupNumber;
    }
}
