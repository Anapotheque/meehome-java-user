package fr.meehome.user.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import fr.meehome.user.webapp.model.User;
import fr.meehome.user.webapp.validation.UserValidator;

@Controller
@RequestMapping("/accueil")
public class AccueilController {

    @ModelAttribute("user")
    public User initForm(HttpServletRequest request) {
        String login = request.getRemoteUser();
        User user = new User();
        return user;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String init() {
        return "accueil";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String connexion(@ModelAttribute("user")
    User user, BindingResult result, SessionStatus status) {

        new UserValidator().validate(user, result);

        if (result.hasErrors()) {
            return "accueil";
        } else {
            status.setComplete();
            return "accueil";
        }
    }
}
