package eu.busi.ACAPizza.controller;

import eu.busi.ACAPizza.Constants;
import eu.busi.ACAPizza.dataAccess.dao.IngredientDAO;
import eu.busi.ACAPizza.dataAccess.dao.PizzaDAO;
import eu.busi.ACAPizza.dataAccess.entity.IngredientEntity;
import eu.busi.ACAPizza.dataAccess.util.ProviderConverter;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value="/pizzaPerso")
@SessionAttributes({Constants.CURRENT_USER})
public class PizzaPersoController {

     static int count = 1;
    static int id = 100;

    @Autowired
    ProviderConverter providerConverter;

    @Autowired
    public IngredientDAO ingredientDAO;

    @Autowired
    public PizzaDAO pizzaDAO;

    @Autowired
    PanierService panierService;


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
        pizzaCustom.getIngredientsString().add("pate ag");
        pizzaCustom.getIngredientsString().add("sauce tomate");
        pizzaCustom.getIngredientsString().add("mozzarella");

        pizzaCustom.setPrice((float) 14.06);
        Set<Ingredient> ingred = ingredientDAO.getAllIngredients()
                .stream()
                .filter(i-> pizzaCustom.getIngredientsString().contains(i.getName()))
                .collect(Collectors.toSet())
                .stream()
                .map(in->providerConverter.ingredientEntityToingredientModel(in)).collect(Collectors.toSet());
        pizzaCustom.setIngredients(ingred);
        panierService.addCustom(user, pizzaCustom);


//        pizzaDAO.save(pizzaCustom);
            return "redirect:/panier";



    }
}
