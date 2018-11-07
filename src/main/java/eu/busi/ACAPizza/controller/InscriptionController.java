package eu.busi.ACAPizza.controller;


import eu.busi.ACAPizza.Constants;
import eu.busi.ACAPizza.dataAccess.dao.UserDAO;
import eu.busi.ACAPizza.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/inscription")
@SessionAttributes({Constants.CURRENT_USER})
public class InscriptionController {

    @ModelAttribute(Constants.CURRENT_USER)
    public User user(){
        return new User();
    }

    @Autowired
    public UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){

        return "integrated:inscription";
    }

    @RequestMapping(value="/send", method = RequestMethod.POST)
    public String getFormData (Model model, @Valid @ModelAttribute(value=Constants.CURRENT_USER) User user, final BindingResult errors){
        if (!errors.hasErrors()){

            userDAO.save(user);
            return "redirect:/home";
        }
        return "/WEB-INF/jsp/keyError.jsp";
    }

}
