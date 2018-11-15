package eu.busi.ACAPizza.controller;

import eu.busi.ACAPizza.Constants;
import eu.busi.ACAPizza.dataAccess.dao.IngredientDAO;
import eu.busi.ACAPizza.dataAccess.dao.OrderDAO;
import eu.busi.ACAPizza.dataAccess.dao.PizzaDAO;
import eu.busi.ACAPizza.dataAccess.dao.UserDAO;
import eu.busi.ACAPizza.dataAccess.entity.OrderEntity;
import eu.busi.ACAPizza.dataAccess.entity.PizzaEntity;
import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.dataAccess.repository.OrderRepository;
import eu.busi.ACAPizza.dataAccess.util.ProviderConverter;
import eu.busi.ACAPizza.model.*;
import eu.busi.ACAPizza.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.*;
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
    OrderRepository orderRepository;

    @Autowired
    public PizzaDAO pizzaDAO;

    @Autowired
    public OrderDAO orderDAO;

    @Autowired
    public IngredientDAO ingredientDAO;

    @Autowired
    ProviderConverter providerConverter;

   private LocalDateTime date = LocalDateTime.now();

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model, @ModelAttribute(value= Constants.CURRENT_USER) User user, Principal principal ){

        if (principal != null){
           Optional<OrderEntity> oe = orderRepository.findAll().stream().filter(o -> o.getClient().getUsername().equals(principal.getName())).filter(o->o.getPaid().equals(false)).findFirst();
//           if ( oe.isPresent() && oe.get().getPaid() == true) {
//
//               Order ord = new Order(user,date,false);
//               orderDAO.save(ord);
//           }
// else
        if (oe.isPresent()&& oe.get().getPaid() == false) {
//               user.getOrders().add(providerConverter.orderEntityToOrderModel(oe.get()));
//               orderDAO.notPaidOrder(user).getCommandeLine()
//                       .stream()
//                       .forEach( p -> {
//                          Pizza pizza = p.getPizza();
//                          int qtt = p.getQuantity();
//                          user.getPanier().put(pizza, qtt);
//
//                       });

           } else if (!oe.isPresent()) {
                Order ord = new Order(user,date,false);
                orderDAO.save(ord);

           }
        }
        model.addAttribute(Constants.CURRENT_USER,user);
        model.addAttribute("panier", user.getPanier());
        model.addAttribute("prixTotal", panierService.calculPrixTotal(user).get()/100.0);

        return "integrated:panier";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/remove/{pizzaName}")
    public String remove (Model model,
                          @Valid @ModelAttribute(value= Constants.CURRENT_USER) User user,
                              @PathVariable("pizzaName") String name, Principal principal){

        Pizza pizza= user.getPanier().keySet().stream().filter(p -> p.getName().equals(name)).findFirst().get();


            panierService.removeProduct(pizza);

        return "redirect:/panier";
        }

    @RequestMapping(method = RequestMethod.GET, value = "/removeOne/{pizzaName}")
    public String removeOne (Model model, @Valid @ModelAttribute(value= Constants.CURRENT_USER) User user,
                          final BindingResult errors, @PathVariable("pizzaName") String name){

        Pizza pizza= user.getPanier().keySet().stream().filter(p -> p.getName().equals(name)).findFirst().get();


        panierService.removeOneProduct(pizza);
        return "redirect:/panier";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addOne/{pizzaName}")
    public String addOne (Model model, @Valid @ModelAttribute(value= Constants.CURRENT_USER) User user,
                             final BindingResult errors, @PathVariable("pizzaName") String name){


        Pizza pizza= user.getPanier().keySet().stream().filter(p -> p.getName().equals(name)).findFirst().get();

        panierService.add(user, pizza);
        return "redirect:/panier";
    }


}
