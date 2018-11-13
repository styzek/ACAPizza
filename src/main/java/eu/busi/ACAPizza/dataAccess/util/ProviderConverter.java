package eu.busi.ACAPizza.dataAccess.util;

import eu.busi.ACAPizza.dataAccess.dao.IngredientDAO;
import eu.busi.ACAPizza.dataAccess.entity.IngredientEntity;
import eu.busi.ACAPizza.dataAccess.entity.PizzaEntity;
import eu.busi.ACAPizza.dataAccess.entity.RoleEntity;
import eu.busi.ACAPizza.dataAccess.entity.UserEntity;
import eu.busi.ACAPizza.model.Ingredient;
import eu.busi.ACAPizza.model.Pizza;
import eu.busi.ACAPizza.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
//@Service
public class ProviderConverter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder xxx = new BCryptPasswordEncoder();
        return xxx;
    }

    @Autowired
    private PasswordEncoder xxx;

    @Autowired
    IngredientDAO ingredientDAO;


    public UserEntity userModelToUserEntity(User user) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setLastName(user.getLastName());
        userEntity.setAdress(user.getAdress());
        userEntity.setZipCode(user.getZipCode());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setPassword(xxx.encode(user.getPassword()));
        userEntity.setPhone(user.getPhone());
        userEntity.setAccountNonExpired(true);
        userEntity.setAccountNonLocked(true);
        userEntity.setCredentialsNonExpired(true);
        userEntity.setEnable(true);
        RoleEntity role = new RoleEntity("ROLE_USER");
        Set<RoleEntity> xyz = new HashSet<>();
        xyz.add(role);
        userEntity.setRoles(xyz);
        return userEntity;

    }

    public User userEntityToUserModel(UserEntity userEntity) {

        User user = new User();
        user.setUsername(userEntity.getUsername());
        user.setLastName(userEntity.getLastName());
        user.setAdress(userEntity.getAdress());
        user.setZipCode(userEntity.getZipCode());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        user.setPhone(userEntity.getPhone());


        return user;
    }

    public PizzaEntity pizzaModelTopizzaEntity(Pizza pizza) {

        PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaEntity.setName(pizza.getName());
        pizzaEntity.setDescription(pizza.getDescription());
        pizzaEntity.setIscomposed(pizza.isIscomposed());
        pizzaEntity.setPrice(pizza.getPrice());
     //   pizzaEntity.setPizzaId(pizza.getPizzaId());
        pizzaEntity.setSize(pizza.getSize());
        Set<IngredientEntity> ingredients =
                pizza.getIngredientsString()
                        .stream()
                        .map(p -> ingredientDAO
                                    .getAllIngredients()
                                    .stream()
                                    .filter(i -> i.getName().equals(p))
                                    .findFirst()
                                    .get())
                        .collect(Collectors.toSet());
// mon avis sur une méthode proprepizzaEntity.setIngredientity.getDescription());
//        pizza.setIscomposed(pizzaEntity.isIscomposed());
//        pizza.setPrice(pizzaEntits(ingredients);
        pizzaEntity.setIngredients(ingredients);

        return pizzaEntity;

    }

    public Pizza pizzaEntityToPizzaModel(PizzaEntity pizzaEntity) {
        Pizza pizza = new Pizza();
        pizza.setName(pizzaEntity.getName());
        pizza.setDescription(pizzaEntity.getDescription());
        pizza.setPrice(pizzaEntity.getPrice());
   //     pizza.setPizzaId(pizzaEntity.getPizzaId());
        pizza.setSize(pizzaEntity.getSize());
        // pizza.setIngredients(pizzaEntity.getIngredients().stream().map(p->p.getName()).collect(Collectors.toList()));
        return pizza;
    }

    public Ingredient ingredientEntityToingredientModel(IngredientEntity ingredientEntity) {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(ingredientEntity.getIngredientId());
        ingredient.setName(ingredientEntity.getName());
        // ingredient.setPizzas( pizzaEntityToPizzaModel(ingredientEntity.getPizzas());
        ingredient.setStock(ingredientEntity.getStock());
        return ingredient;
    }

    public IngredientEntity ingredientModelToingredientEntity(Ingredient ingredient) {
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setIngredientId(ingredient.getIngredientId());
        ingredientEntity.setName(ingredient.getName());
        // ingredient.setPizzas( pizzaEntityToPizzaModel(ingredientEntity.getPizzas());
        ingredientEntity.setStock(ingredient.getStock());
        return ingredientEntity;
    }


}
