package fr.meehome.user.webapp.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.meehome.user.webapp.model.Authentification;
import fr.meehome.user.webapp.model.User;
import fr.meehome.user.webapp.model.Validation;
import fr.meehome.user.webapp.utils.Pages;

@Controller
@RequestMapping("/accueil")
public class AccueilController extends MetaController {

    private static final Logger LOG = Logger.getLogger(AccueilController.class);

    /**
     * On affiche la page d'accueil
     * 
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String accueil(ModelMap model) {
        return Pages.ACCUEIL.getLibelle();
    }

    /**
     * On affiche la page d'inscription
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/inscription", method = RequestMethod.GET)
    public String inscription(ModelMap model) {
        return Pages.INSCRIPTION_USER.getLibelle();
    }

    /**
     * On affiche la page d'authentification
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/authentification", method = RequestMethod.GET)
    public String authentification(ModelMap model) {
        return Pages.AUTHENTIFICATION_USER.getLibelle();
    }

    /**
     * On affiche la page de mise a jour user
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateUser(ModelMap model) {
        return Pages.UPDATE_USER.getLibelle();
    }

    /**
     * Validation du formulaire de mise a jour user
     * 
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String valideUpdate(@ModelAttribute("user")
    @Valid
    User user, BindingResult result, ModelMap model) {
        LOG.debug("valideUpdate User");
        if (result.hasErrors()) {
            return Pages.UPDATE_USER.getLibelle();
        }
        model.addAttribute("validation", new Validation("Le formulaire a été validé avec success"));
        return Pages.VALIDATION_FORMULAIRE_SUCCESS.getLibelle();
    }

    /**
     * Validation du formulaire d'inscription
     * 
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(value = "/inscription", method = RequestMethod.POST)
    public String valideInscription(@ModelAttribute("user")
    @Valid
    User user, BindingResult result, ModelMap model) {
        LOG.debug("valideInscription User");
        if (result.hasErrors()) {
            return Pages.INSCRIPTION_USER.getLibelle();
        }
        model.addAttribute("validation", new Validation("Le formulaire a été validé avec success"));
        return Pages.VALIDATION_FORMULAIRE_SUCCESS.getLibelle();
    }

    /**
     * Validation du formulaire d'authentification
     * 
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(value = "/authentification", method = RequestMethod.POST)
    public String valideAuthentification(@ModelAttribute("authentification")
    @Valid
    Authentification authentification, BindingResult result, ModelMap model) {
        LOG.debug("valideAuthentification User");
        if (result.hasErrors()) {
            return Pages.AUTHENTIFICATION_USER.getLibelle();
        }
        model.addAttribute("validation", new Validation("Authentification",
                        "Vous etes authorisé à vous connecté aux applications suivantes : .... en tant que : ....",
                        "panel-default"));
        return Pages.VALIDATION_FORMULAIRE_SUCCESS.getLibelle();
    }

}
