package eu.busi.ACAPizza.controller;

import eu.busi.ACAPizza.Constants;
import eu.busi.ACAPizza.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
//@RequestMapping(value = "/login")
@SessionAttributes({Constants.CURRENT_USER})
public class LoginController {


//    @ModelAttribute(Constants.CURRENT_USER)
//    public User user(){
//        return new User();
//    }

    @RequestMapping( method = RequestMethod.GET, value = "/loginPage")
    public String getFormData (Model model, @ModelAttribute(value= Constants.CURRENT_USER) User user){

        return "integrated:loginPage";
    }
}
