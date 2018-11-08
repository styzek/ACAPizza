package eu.busi.ACAPizza.controller;


import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.dataAccess.dao.UserDAO;
import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.model.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping(value="/home")
public class WelcomeController {


    @ModelAttribute(value = "userForm")
    public UserForm user(){
        return new UserForm();
    }

    @Autowired
    public UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){

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

//    @RequestMapping(value="/connect", method = RequestMethod.POST)
//    public String getFormData (Model model, @Valid @ModelAttribute(value="userForm") UserForm user){
//
//
//        UserEntity user1 = userDAO.getUser(user.getEmail(), user.getPassword());
//
//        if(user1 != null) {
//            return "redirect:/pizza";
//        }
//
//        return "/WEB-INF/jsp/keyError.jsp";
//    }


}
