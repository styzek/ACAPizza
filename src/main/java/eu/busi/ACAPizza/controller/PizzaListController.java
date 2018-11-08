package eu.busi.ACAPizza.controller;


import eu.busi.ACAPizza.Constants;
import eu.busi.ACAPizza.dataAccess.dao.UserDAO;
import eu.busi.ACAPizza.dataAccess.entity.OrderEntity;
import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.model.Pizza;
import eu.busi.ACAPizza.model.User;

import eu.busi.ACAPizza.dataAccess.dao.PizzaDAO;
import eu.busi.ACAPizza.dataAccess.repository.PizzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/pizza")
public class PizzaListController {

    @ModelAttribute(value = "pizza")
    public Pizza pizza(){
        return new Pizza();
    }

    @Autowired
    public UserDAO userDAO;


    @Autowired
    public PizzaDAO pizzaDAO;

    private PizzaRepository pizzaRepository;


    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){

        model.addAttribute("pizzas", pizzaDAO.getAllPizza());

        return "integrated:pizzaList";
    }

    @RequestMapping(value="/ajout", method = RequestMethod.POST)
    public void getFormData (Model model, @Valid @ModelAttribute(value= Constants.CURRENT_USER) User user,
                                    final BindingResult errors, @ModelAttribute(value="pizza") Pizza pizza){
        if (!errors.hasErrors()){
            OrderEntity orderEntity = new OrderEntity();



        }

    }



}
