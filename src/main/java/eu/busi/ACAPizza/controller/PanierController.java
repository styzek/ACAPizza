package eu.busi.ACAPizza.controller;

import eu.busi.ACAPizza.Constants;
import eu.busi.ACAPizza.dataAccess.dao.IngredientDAO;
import eu.busi.ACAPizza.dataAccess.dao.PizzaDAO;
import eu.busi.ACAPizza.dataAccess.dao.UserDAO;
import eu.busi.ACAPizza.dataAccess.entity.OrderEntity;
import eu.busi.ACAPizza.dataAccess.entity.PizzaEntity;
import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.dataAccess.util.ProviderConverter;
import eu.busi.ACAPizza.model.Pizza;
import eu.busi.ACAPizza.model.User;
import eu.busi.ACAPizza.model.UserForm;
import eu.busi.ACAPizza.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value="/panier")
@SessionAttributes({Constants.CURRENT_USER})
public class PanierController {

    @Autowired
    PanierService panierService;


    @Autowired
    public UserDAO userDAO;


    @Autowired
    public PizzaDAO pizzaDAO;

    @Autowired
    public IngredientDAO ingredientDAO;

    @Autowired
    ProviderConverter providerConverter;

//    @ModelAttribute(value = "pizza")
//    public Pizza pizza(){
//        return new Pizza();
//    }



    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model, @ModelAttribute(value= Constants.CURRENT_USER) User user ){
//        UserEntity user = (UserEntity)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        AtomicInteger totalPriceInCentime = new AtomicInteger(0);


        user.getPanier().entrySet().stream().forEach( pentry -> {
            int centimeParPizza = (int) (pentry.getKey().getPrice()*100);
            Integer quantity = pentry.getValue();
            int prixEnCentime = centimeParPizza * quantity;
            System.out.println("prix pizza en centime: " + prixEnCentime);
            totalPriceInCentime.addAndGet(prixEnCentime);
            System.out.println("prix intermédiaire en centime: " + totalPriceInCentime.get());
        });
        System.out.println("prix total : " + totalPriceInCentime.get()/100.0);
        System.out.println("--------------");

        model.addAttribute("user",user);
        model.addAttribute("panier", user.getPanier());
        model.addAttribute("prixTotal", totalPriceInCentime.get()/100.0);
//        model.addAttribute("pizza", new Pizza());




        return "integrated:panier";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/remove/{pizzaName}")
    public String remove (Model model, @Valid @ModelAttribute(value= Constants.CURRENT_USER) User user,
                             final BindingResult errors, @PathVariable("pizzaName") String name){

        PizzaEntity pizza1 = pizzaDAO.getAllPizza().stream().filter(p -> p.getName().equals(name)).findFirst().get();
        Pizza pizza = providerConverter.pizzaEntityToPizzaModel(pizza1);


        panierService.removeProduct(pizza);
        return "redirect:/panier";
        }

    @RequestMapping(method = RequestMethod.GET, value = "/removeOne/{pizzaName}")
    public String removeOne (Model model, @Valid @ModelAttribute(value= Constants.CURRENT_USER) User user,
                          final BindingResult errors, @PathVariable("pizzaName") String name){

        PizzaEntity pizza1 = pizzaDAO.getAllPizza().stream().filter(p -> p.getName().equals(name)).findFirst().get();
        Pizza pizza = providerConverter.pizzaEntityToPizzaModel(pizza1);


        panierService.removeOneProduct(pizza);
        return "redirect:/panier";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addOne/{pizzaName}")
    public String addOne (Model model, @Valid @ModelAttribute(value= Constants.CURRENT_USER) User user,
                             final BindingResult errors, @PathVariable("pizzaName") String name){

        PizzaEntity pizza1 = pizzaDAO.getAllPizza().stream().filter(p -> p.getName().equals(name)).findFirst().get();
        Pizza pizza = providerConverter.pizzaEntityToPizzaModel(pizza1);


        panierService.add(user, pizza);
        return "redirect:/panier";
    }


}
