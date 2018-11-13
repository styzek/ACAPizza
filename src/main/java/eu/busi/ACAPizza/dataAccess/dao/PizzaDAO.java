package eu.busi.ACAPizza.dataAccess.dao;

import eu.busi.ACAPizza.dataAccess.entity.IngredientEntity;
import eu.busi.ACAPizza.dataAccess.entity.PizzaEntity;
import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.dataAccess.repository.IngredientRepository;
import eu.busi.ACAPizza.dataAccess.repository.PizzaRepository;
import eu.busi.ACAPizza.dataAccess.repository.UserRepository;
import eu.busi.ACAPizza.dataAccess.util.ProviderConverter;
import eu.busi.ACAPizza.model.Pizza;
import eu.busi.ACAPizza.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class PizzaDAO {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    ProviderConverter providerConverter;

    public List<PizzaEntity> getAllPizza () {
         List<PizzaEntity> pizzas = pizzaRepository.findAll();


         return pizzas;
    }

    public List<PizzaEntity> getPizzaByCategory (String category) {
        List<PizzaEntity> pizzas = pizzaRepository.findAll().stream().filter( p -> p.getCategories().equals(category)).collect(Collectors.toList());

        return pizzas;
    }

    public Set<IngredientEntity> getPizzaIngredients (PizzaEntity pizza) {
        PizzaEntity pizza2 = pizzaRepository.findAll().stream().filter( p -> p.getPizzaId()==pizza.getPizzaId()).findFirst().get();
        Set<IngredientEntity> ingredients = pizza2.getIngredients();

        return ingredients;
    }


    public Pizza save(Pizza pizza) {
        PizzaEntity pizzaEntity = providerConverter.pizzaModelTopizzaEntity(pizza);
        pizzaEntity = pizzaRepository.save(pizzaEntity);
        return providerConverter.pizzaEntityToPizzaModel(pizzaEntity);

    }

}
