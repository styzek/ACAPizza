package eu.busi.ACAPizza.controller;

import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value="/home")
public class WelcomeController {


    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){

        return "integrated:welcome";
    }


}
