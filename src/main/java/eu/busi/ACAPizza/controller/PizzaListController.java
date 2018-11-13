package eu.busi.ACAPizza.controller;


import eu.busi.ACAPizza.Constants;
import eu.busi.ACAPizza.dataAccess.dao.IngredientDAO;
import eu.busi.ACAPizza.dataAccess.dao.UserDAO;
import eu.busi.ACAPizza.dataAccess.entity.PizzaEntity;
import eu.busi.ACAPizza.dataAccess.util.ProviderConverter;
import eu.busi.ACAPizza.model.Pizza;
import eu.busi.ACAPizza.model.User;

import eu.busi.ACAPizza.dataAccess.dao.PizzaDAO;

import eu.busi.ACAPizza.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/pizza")
@SessionAttributes({Constants.CURRENT_USER})
public class PizzaListController {


    @Autowired
    public UserDAO userDAO;

    @Autowired
    public PizzaDAO pizzaDAO;

    @Autowired
    public IngredientDAO ingredientDAO;

    @Autowired
    PanierService panierService;

    @Autowired
    ProviderConverter providerConverter;



    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){

        System.out.println(pizzaDAO.getAllPizza());
        model.addAttribute("pizzas", pizzaDAO.getAllPizza());
        model.addAttribute("ingredients", ingredientDAO.getAllIngredients());

        return "integrated:pizzaList";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add/{pizzaName}")
    public String add(Model model, @ModelAttribute(value = Constants.CURRENT_USER) User user,
                      @PathVariable("pizzaName") String name) {

        PizzaEntity pizza1 = pizzaDAO.getAllPizza().stream().filter(p -> p.getName().equals(name)).findFirst().get();
        Pizza pizza = providerConverter.pizzaEntityToPizzaModel(pizza1);
        {
            panierService.add(user, pizza);


            return "redirect:/panier";
        }
    }

}
