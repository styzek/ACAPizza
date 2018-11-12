package eu.busi.ACAPizza.controller;

import eu.busi.ACAPizza.Constants;
import eu.busi.ACAPizza.dataAccess.dao.IngredientDAO;
import eu.busi.ACAPizza.model.Pizza;
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
@RequestMapping(value="/pizzaPerso")
@SessionAttributes({Constants.CURRENT_USER})
public class PizzaPersoController {

    @Autowired
    public IngredientDAO ingredientDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("ingredients", ingredientDAO.getAllIngredients());
        model.addAttribute("pizzaCustom", new Pizza());
        return "integrated:pizzaPerso";
    }


    @RequestMapping(value="/send", method = RequestMethod.POST)
    public String getFormData (Model model, @ModelAttribute(value=Constants.CURRENT_USER) User user,@ModelAttribute("pizzaCustom") Pizza pizza ){

            return "redirect:/panier";

    }
}
