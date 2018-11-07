package eu.busi.ACAPizza.controller;

import eu.busi.ACAPizza.dataAccess.dao.UserDAO;
import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/pizza")
public class PizzaListController {


    @Autowired
    public UserDAO userDAO;


    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){

        userDAO.save( new UserEntity(1,"Konrad","Wysk"));
        return "integrated:pizzaList";
    }

}
