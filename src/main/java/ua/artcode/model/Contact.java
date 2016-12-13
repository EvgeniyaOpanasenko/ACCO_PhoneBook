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
    private String phone_type;
    private String group;
    private String group_type;
   /* private Phone phone;
    private Group group;
    private Date dateOfCreation;
    private Date dateOfModication;*/


    public Contact(String name, String surname,
                   String address, String skype, String mail,
                   String phone, String phone_type, String group,
                   String group_type ) throws InvalidNameSurnameException {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.skype = skype;
        this.mail = mail;
        this.phone = phone;
        this.phone_type = phone_type;
        this.group = group;
        this.group_type = group_type;

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

    public String getPhone_type() {
        return phone_type;
    }

    public String getGroup_type() {
        return group_type;
    }
}
