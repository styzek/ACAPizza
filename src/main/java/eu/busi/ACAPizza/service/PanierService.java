package eu.busi.ACAPizza.service;

import eu.busi.ACAPizza.model.Pizza;
import eu.busi.ACAPizza.model.User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PanierService {

    public User add (User user,Pizza pizza){

        Map<Pizza,Integer> x = user.getPanier();
        if (x.containsKey(pizza)){
            int quantity = x.get(pizza);
            x.put(pizza, quantity + 1);
        }
        else
            x.put(pizza,1);

        user.setPanier(x);
        return user;
    }

    public User remove (User user,Pizza pizza){

        Map<Pizza,Integer> x = user.getPanier();

        if (x.containsKey(pizza)){
            int quantity = x.get(pizza);
            if (x.get(pizza) !=0)
            x.put(pizza, quantity - 1);
        }
        user.setPanier(x);

        return user;
    }

}
