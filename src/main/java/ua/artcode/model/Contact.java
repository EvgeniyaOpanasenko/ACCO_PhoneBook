package ua.artcode.model;

import ua.artcode.exceptions.InvalidNameSurnameException;

import static ua.artcode.utils.ValidationUtils.validateNameSurname;

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
    private String phoneType;
    private String group;
    private String groupType;


    public Contact(String name, String surname,
                   String address, String skype, String mail,
                   String phone, String phoneType, String group,
                   String groupType ) throws InvalidNameSurnameException {
        this.name = name;
        validateNameSurname(name);
        this.surname = surname;
        validateNameSurname(surname);
        this.address = address;
        this.skype = skype;
        this.mail = mail;
        this.phone = phone;
        this.phoneType = phoneType;
        this.group = group;
        this.groupType = groupType;

//        TODO add another validations
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

    public String getPhoneType() {
        return phoneType;
    }

    public String getGroupType() {
        return groupType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (!name.equals(contact.name)) return false;
        if (!surname.equals(contact.surname)) return false;
        return phone.equals(contact.phone);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }
}
