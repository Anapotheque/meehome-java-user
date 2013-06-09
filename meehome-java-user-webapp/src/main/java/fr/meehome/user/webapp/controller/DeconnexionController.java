package fr.meehome.user.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.meehome.user.webapp.model.User;

@Controller
@RequestMapping("/deconnexion")
public class DeconnexionController {

    @RequestMapping(method = RequestMethod.GET)
    public String accueil(ModelMap model) {
        model.addAttribute("user", new User());
        model.put("authorized", false);
        return "redirect:accueil";
    }
}
