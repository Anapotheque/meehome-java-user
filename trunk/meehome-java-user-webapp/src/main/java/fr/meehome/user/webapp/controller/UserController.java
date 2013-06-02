package fr.meehome.user.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import fr.meehome.user.webapp.model.User;

@Controller
@RequestMapping("/inscription")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/user/inscription";
    }

    /*
     * UserValidator userValidator;
     * @Autowired public UserController(UserValidator userValidator) {
     * this.userValidator = userValidator; }
     */
    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("user")
    User user, BindingResult result, SessionStatus status) {

        // userValidator.validate(user, result);

        if (result.hasErrors()) {
            return "/user/inscription";
        } else {
            status.setComplete();
            return "/user/inscriptionSuccess";
        }
    }

}
