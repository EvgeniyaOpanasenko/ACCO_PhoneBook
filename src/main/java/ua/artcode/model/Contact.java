package ua.artcode.model;

import ua.artcode.exceptions.InvalidNameSurnameException;

import java.util.Date;

import static ua.artcode.utils.ValidationUtils.validateName;
import static ua.artcode.utils.ValidationUtils.validateSurname;

/**
 * Created by Lisa on 12/12/2016.
 */
public class Contact {
    private String name;
    private String surname;
    private String address;
    private String skype;
    private String mail;
    private String phone;
    private String group;
   /* private Phone phone;
    private Group group;
    private Date dateOfCreation;
    private Date dateOfModication;*/


    public Contact(String name, String surname,
                   String address, String skype, String mail, String phone, String group) throws InvalidNameSurnameException {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.skype = skype;
        this.mail = mail;
        this.phone = phone;
        this.group = group;

        validateName(name);
        validateSurname(surname);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getSkype() {
        return skype;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getGroup() {
        return group;
    }

}
