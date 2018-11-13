package eu.busi.ACAPizza.controller;

import eu.busi.ACAPizza.Constants;
import eu.busi.ACAPizza.dataAccess.dao.UserDAO;
import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.model.User;
import eu.busi.ACAPizza.model.UserForm;
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
@RequestMapping(value="/connection")
@SessionAttributes({Constants.CURRENT_USER})
public class ConnexionController {
//
//    @ModelAttribute(value = "userForm")
//    public UserForm user(){
//        return new UserForm();
//    }
//
//    @ModelAttribute(Constants.CURRENT_USER)
//    public User user(){
//        return new User();
//    }
//
//
//    @Autowired
//    public UserDAO userDAO;
//
//
//
//    @RequestMapping(method = RequestMethod.GET)
//    public String home (Model model){
//
//                return "integrated:login";
//
//
//    }
//
//    @RequestMapping(value="/loginP", method = RequestMethod.GET)
//    public String getFormData (Model model, @Valid @ModelAttribute(value="userForm") UserForm user){
//
//                return "redirect:/home";
//
//    }
}
