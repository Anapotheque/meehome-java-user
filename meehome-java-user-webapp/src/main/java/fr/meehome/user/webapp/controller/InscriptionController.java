package fr.meehome.user.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import fr.meehome.user.webapp.model.User;
import fr.meehome.user.webapp.validation.UserValidator;

@Controller
@RequestMapping("/inscription")
public class InscriptionController {

    private final String VIEW = "inscription";

    @RequestMapping(method = RequestMethod.GET)
    public String inscription(ModelMap model) {
        model.addAttribute("user", new User());
        return VIEW;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String connexion(@ModelAttribute("user")
    User user, BindingResult result, SessionStatus status) {
        new UserValidator().validate(user, result);
        if (result.hasErrors()) {
            return VIEW;
        }
        status.setComplete();
        return VIEW;
    }
}
