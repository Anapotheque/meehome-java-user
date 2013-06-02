package fr.meehome.user.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.meehome.user.webapp.model.User;

@Controller
public class AccueilController {

    @ModelAttribute("user")
    public User initForm(HttpServletRequest request) {
        User user = new User();
        return user;
    }

    @RequestMapping(value = "/accueil")
    public String accueil(ModelMap model) {
        model.addAttribute("user", new User());
        return "accueil";
    }

    @RequestMapping(value = "/inscription")
    public String inscription(ModelMap model) {
        model.addAttribute("user", new User());
        return "inscription";
    }

    /*
     * @RequestMapping(value = "/accueil", method = RequestMethod.POST) public
     * String connexion(@ModelAttribute("user") User user, BindingResult result,
     * SessionStatus status) { new LoginValidator().validate(user, result); if
     * (user.getLogin().equals(userGood.getLogin()) &&
     * user.getPassword().equals(userGood.getPassword())) {
     * System.out.println("user OK"); } else { System.out.println("user KO"); }
     * status.setComplete(); return "accueil"; }
     */
}
