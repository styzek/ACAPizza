package eu.busi.ACAPizza.service;

import eu.busi.ACAPizza.dataAccess.entity.PizzaEntity;
import eu.busi.ACAPizza.dataAccess.repository.PizzaRepository;
import eu.busi.ACAPizza.dataAccess.util.ProviderConverter;
import eu.busi.ACAPizza.model.Pizza;
import eu.busi.ACAPizza.model.User;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class PanierService {

    private HashMap<Pizza, Integer> panierMap = new HashMap<>();

    ProviderConverter pro;

    private PizzaRepository pizzaRepository;

    public void add(User user, Pizza pizza) {

        if (panierMap.containsKey(pizza)){

            panierMap.computeIfPresent(pizza, ((pizza1, qtt) -> qtt + 1));

        } else {
            panierMap.put(pizza,1);
        }
            user.setPanier(panierMap);
        }


    public void removeOneProduct(Pizza pizza) {
        if (panierMap.containsKey(pizza)) {
            if (panierMap.get(pizza) > 1)
                panierMap.replace(pizza, panierMap.get(pizza) - 1);

        }
    }

    public void addOneProduct(Pizza pizza) {
        if (panierMap.containsKey(pizza)) {

            panierMap.put(pizza, panierMap.get(pizza) + 1);

        }
    }
//        public Optional<PizzaEntity> findByID ( int id){
//            return pizzaRepository.findById(id);
//        }

//    public User remove (User user,Pizza pizza){
//
//        Map<Pizza,Integer> x = user.getPanier();
//
//        if (x.containsKey(pizza)){
//            int quantity = x.get(pizza);
//            if (x.get(pizza) !=0)
//            x.put(pizza, quantity - 1);
//        }
//        user.setPanier(x);
//
//        return user;
//    }

    public void removeProduct(Pizza pizza) {
        if (panierMap.containsKey(pizza)) {

                panierMap.remove(pizza);
            }
        }




//    public float calcul(User user) {
//
//               HashMap<Pizza,Integer>  mapcalcul= user.getPanier();
//
//               mapcalcul.entrySet().stream().forEach((k)->  {float i = (k.getKey().getPrice()*k.getValue());})
//
//    }

    }

