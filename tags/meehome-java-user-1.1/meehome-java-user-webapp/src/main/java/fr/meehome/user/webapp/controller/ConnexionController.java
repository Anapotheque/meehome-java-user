package fr.meehome.user.webapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.meehome.user.webapp.model.Authentification;
import fr.meehome.user.webapp.model.User;
import fr.meehome.user.webapp.utils.Pages;

@Controller
@RequestMapping("/connexion")
public class ConnexionController {

    // VALIDATION FORMULAIRE DE CONNEXION
    @RequestMapping(method = RequestMethod.POST)
    public String connexion(@Valid Authentification authentification, BindingResult result, ModelMap model) {
        if (!result.hasErrors()) {
            if (!authentification.getEmail().equals("raballand.romain@gmail.com") || !authentification.getPassword().equals("13041983")) {
                result.addError(new ObjectError("authentification.failed", "Votre login ou votre mot de passe n'est pas valide"));
            } else {
                User user = new User();
                user.setNom("RABALLAND");
                user.setPrenom("Romain");
                user.setEmail("raballand.romain@gmail.com");
                model.addAttribute("userAuthentificated", user);
            }
        }
        return Pages.ACCUEIL.getLibelle();
    }

}
