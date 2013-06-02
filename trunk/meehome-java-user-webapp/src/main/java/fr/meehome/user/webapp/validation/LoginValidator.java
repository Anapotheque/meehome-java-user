package fr.meehome.user.webapp.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.meehome.user.webapp.model.User;

public class LoginValidator implements Validator {

    @Override
    public boolean supports(Class< ? > clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "required.connexion.login", "Votre login est requis");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.connexion.password", "Votre mot de passe est requis");
    }
}
