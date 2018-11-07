package eu.busi.ACAPizza.controller;

import eu.busi.ACAPizza.dataAccess.dao.PizzaDAO;
import eu.busi.ACAPizza.dataAccess.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/pizza")
public class PizzaListController {

    @Autowired
    public PizzaDAO pizzaDAO;

    private PizzaRepository pizzaRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){

        model.addAttribute("pizzas", pizzaDAO.getAllPizza());

        return "integrated:pizzaList";
    }



}
