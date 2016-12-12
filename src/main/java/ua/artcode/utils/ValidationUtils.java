package ua.artcode.utils;

import ua.artcode.exceptions.InvalidNameSurnameException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lisa on 12/12/2016.
 */
public class ValidationUtils {
    private static final String NAME_PATTERN = "[A-Z][a-zA-Z1-9]{2,15}";

    public static void validateSurname(String surname) throws InvalidNameSurnameException {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(surname);

        if (!matcher.matches())
            throw new InvalidNameSurnameException("Invalid name or surname");
    }

    public static void validateName(String name) throws InvalidNameSurnameException {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);

        if (!matcher.matches())
            throw new InvalidNameSurnameException("Invalid name or surname");

    }
}
