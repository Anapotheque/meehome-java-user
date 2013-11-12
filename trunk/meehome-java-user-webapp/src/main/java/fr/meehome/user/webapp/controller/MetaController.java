package fr.meehome.user.webapp.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;

import fr.meehome.user.webapp.model.Authentification;
import fr.meehome.user.webapp.model.User;

public class MetaController {

    private static final Logger LOG = Logger.getLogger(MetaController.class);

    /**
     * Creation bean authentification
     * 
     * @return
     */
    @ModelAttribute("authentification")
    public Authentification getAuthentification() {
        LOG.debug("creation du bean d'authentification");
        return new Authentification();
    }

    /**
     * Creation bean user
     * 
     * @return
     */
    @ModelAttribute("user")
    public User getUser() {
        LOG.debug("creation du bean user");
        return new User();
    }
}
