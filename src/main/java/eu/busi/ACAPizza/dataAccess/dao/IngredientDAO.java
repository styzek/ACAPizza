package eu.busi.ACAPizza.dataAccess.dao;

import eu.busi.ACAPizza.dataAccess.entity.IngredientEntity;
import eu.busi.ACAPizza.dataAccess.repository.IngredientRepository;
import eu.busi.ACAPizza.dataAccess.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IngredientDAO {

    @Autowired
    private IngredientRepository ingredientRepository;


    public List<IngredientEntity> getAllIngredients () {
        List<IngredientEntity> ingredients = ingredientRepository.findAll();

        return ingredients;
    }
}
