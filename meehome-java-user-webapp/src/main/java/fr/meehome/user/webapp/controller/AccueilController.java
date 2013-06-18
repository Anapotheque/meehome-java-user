package fr.meehome.user.webapp.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.meehome.user.webapp.model.Authentification;
import fr.meehome.user.webapp.model.User;

@Controller
@RequestMapping("/accueil")
public class AccueilController {

    private static final Logger logger = Logger.getLogger(AccueilController.class);

    @ModelAttribute("authentification")
    public Authentification getAuthentification() {
        return new Authentification();
    }

    // AFFICHE LA PAGE D'ACCUEIL
    @RequestMapping(method = RequestMethod.GET)
    public String accueil(ModelMap model) {
        model.addAttribute("authentification", new Authentification());
        return "accueil";
    }

    // VALIDATION FORMULAIRE DE CONNEXION
    @RequestMapping(value = "/connexion", method = RequestMethod.POST)
    public String connexion(@Valid Authentification authentification, BindingResult result, ModelMap model) {
        if (!result.hasErrors()) {
            if (!authentification.getLogin().equals("Romain") || !authentification.getPassword().equals("13041983")) {
                result.addError(new ObjectError("authentification.failed", "Votre login ou votre mot de passe n'est pas valide"));
            } else {
                User user = new User();
                user.setNom("RABALLAND");
                user.setPrenom("Romain");
                model.addAttribute("userAuthentificated", user);
            }
        }
        return "accueil";
    }

    // AFFICHE LA PAGE D'INSCRIPTION
    @RequestMapping(value = "/inscription", method = RequestMethod.GET)
    public String inscription(ModelMap model) {
        model.addAttribute("authentification", new Authentification());
        model.addAttribute("user", new User());
        return "inscription";
    }

    // VALIDATION FORMULAIRE INSCRIPTION
    @RequestMapping(value = "/inscription", method = RequestMethod.POST)
    public String connexion(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "inscription";
        }
        return "inscriptionSuccess";
    }

}
