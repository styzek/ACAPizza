package eu.busi.ACAPizza.controller;

import eu.busi.ACAPizza.Constants;
import eu.busi.ACAPizza.dataAccess.entity.OrderEntity;
import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.model.Pizza;
import eu.busi.ACAPizza.model.User;
import eu.busi.ACAPizza.model.UserForm;
import eu.busi.ACAPizza.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping(value="/panier")
@SessionAttributes({Constants.CURRENT_USER})
public class PanierController {

    @Autowired
    PanierService panierService;

    @ModelAttribute(value = "pizza")
    public Pizza pizza(){
        return new Pizza();
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public User user(){
        return new User();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model, @ModelAttribute(value= Constants.CURRENT_USER) User user ){
//        UserEntity user = (UserEntity)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("panier", user.getPanier());
//        model.addAttribute("pizza", new Pizza());

        return "integrated:panier";
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/add")
//    public void add (Model model, @Valid @ModelAttribute(value= Constants.CURRENT_USER) User user,
//                             final BindingResult errors, @ModelAttribute(value="pizza") Pizza pizza){
//
//        panierService.add(user, pizza);
//
//        }
}
