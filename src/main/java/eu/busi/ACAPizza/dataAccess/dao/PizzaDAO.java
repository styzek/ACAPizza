package eu.busi.ACAPizza.dataAccess.dao;

import eu.busi.ACAPizza.dataAccess.entity.PizzaEntity;
import eu.busi.ACAPizza.dataAccess.repository.PizzaRepository;
import eu.busi.ACAPizza.dataAccess.repository.UserRepository;
import eu.busi.ACAPizza.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PizzaDAO {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<PizzaEntity> getAllPizza () {
         List<PizzaEntity> pizzas = pizzaRepository.findAll();
         return pizzas;
    }

    public List<PizzaEntity> getPizzaByCategory (String category) {
        List<PizzaEntity> pizzas = pizzaRepository.findAll().stream().filter( p -> p.getCategories().equals(category)).collect(Collectors.toList());

        return pizzas;
    }

}
