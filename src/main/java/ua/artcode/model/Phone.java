package ua.artcode.model;

import ua.artcode.enums.PhoneType;

/**
 * Created by Lisa on 12/12/2016.
 */
public class Phone {
    private String number;
    private PhoneType type;


    public Phone(String number, PhoneType type) {
        this.number = number;
        this.type = type;

    }


}
