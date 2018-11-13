package eu.busi.ACAPizza.controller;

import eu.busi.ACAPizza.Constants;
import eu.busi.ACAPizza.dataAccess.dao.IngredientDAO;
import eu.busi.ACAPizza.dataAccess.dao.PizzaDAO;
import eu.busi.ACAPizza.model.Ingredient;
import eu.busi.ACAPizza.model.Pizza;
import eu.busi.ACAPizza.model.User;
import eu.busi.ACAPizza.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/pizzaPerso")
@SessionAttributes({Constants.CURRENT_USER})
public class PizzaPersoController {

     static int count = 1;
    static int id = 100;

    @Autowired
    public IngredientDAO ingredientDAO;

    @Autowired
    PanierService panierService;

    @Autowired
    PizzaDAO pizzaDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("ingredientList", ingredientDAO.getAllIngredients());
        model.addAttribute("pizzaCustom",new Pizza());
        return "integrated:pizzaPerso";
    }


    @RequestMapping(value="/send", method = RequestMethod.POST)
    public String getFormData (Model model, @ModelAttribute(value=Constants.CURRENT_USER) User user,@ModelAttribute("pizzaCustom") Pizza pizzaCustom  ){

//        model.addAttribute("pizzaCustom", pizzaCustom);
        pizzaCustom.setName("pizzaCustom");
        pizzaCustom.setIscomposed(true);

        pizzaCustom.setPrice((float) 14.06);
        panierService.addCustom(user, pizzaCustom);
        pizzaDAO.save(pizzaCustom);
            return "redirect:/panier";



    }
}
