package eu.busi.ACAPizza.controller;


import eu.busi.ACAPizza.Constants;
import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.dataAccess.dao.UserDAO;
import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.dataAccess.util.ProviderConverter;
import eu.busi.ACAPizza.model.User;
import eu.busi.ACAPizza.model.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.Authenticator;

import javax.validation.Valid;
import java.security.Principal;


@Controller
@RequestMapping(value="/home")
@SessionAttributes({Constants.CURRENT_USER})
public class WelcomeController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    ProviderConverter providerConverter;



    @ModelAttribute(Constants.CURRENT_USER)
    public User user(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return providerConverter.userEntityToUserModel((UserEntity)authentication.getPrincipal());
        }

        return new User();
    }


    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model,@ModelAttribute(value = Constants.CURRENT_USER) User user){
        model.addAttribute( Constants.CURRENT_USER,user());

        return "integrated:welcome";
    }

    @RequestMapping(value = "/connection", method = RequestMethod.GET)
    public String connect (Model model){

        return "redirect:/home";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout (Model model){

        return "integrated:home";
    }



}
