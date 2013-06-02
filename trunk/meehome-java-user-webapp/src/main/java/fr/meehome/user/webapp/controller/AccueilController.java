package fr.meehome.user.webapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import fr.meehome.user.webapp.model.User;
import fr.meehome.user.webapp.validation.LoginValidator;

@Controller
@RequestMapping("/accueil")
public class AccueilController {

    private final String VIEW = "accueil";

    @RequestMapping(method = RequestMethod.GET)
    public String accueil(ModelMap model) {
        model.addAttribute("user", new User());
        model.put("authorized", false);
        return VIEW;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView connexion(@ModelAttribute("user")
    User user, BindingResult result, SessionStatus status) {
        new LoginValidator().validate(user, result);

        Map<String, Object> model = new HashMap<String, Object>();

        if (result.hasErrors()) {
            return new ModelAndView(VIEW, model);
        }

        if (!user.getLogin().equals("test") || !user.getPassword().equals("test")) {
            result.addError(new ObjectError("nonAutorised", "non authorisé"));
        } else {
            user.setNom("Raballand");
            user.setPrenom("Romain");
            model.put("authorized", true);
            status.setComplete();
        }

        return new ModelAndView(VIEW, model);
    }
}
