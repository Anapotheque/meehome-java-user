package fr.meehome.user.webapp.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.meehome.user.webapp.model.User;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "required.login", "Field name is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "required.nom", "Field name is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "required.prenom", "Field name is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Field name is required.");
    }
}
