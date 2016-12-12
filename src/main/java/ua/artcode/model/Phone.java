package ua.artcode.model;

import ua.artcode.enums.Phone_type;

/**
 * Created by Lisa on 12/12/2016.
 */
public class Phone {
    private String number;
    private Phone_type type;


    public Phone(String number, Phone_type type) {
        this.number = number;
        this.type = type;

    }


}
