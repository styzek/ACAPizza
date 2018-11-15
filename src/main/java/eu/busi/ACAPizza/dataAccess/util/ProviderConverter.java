package eu.busi.ACAPizza.dataAccess.util;

import eu.busi.ACAPizza.dataAccess.dao.IngredientDAO;
import eu.busi.ACAPizza.dataAccess.entity.*;
import eu.busi.ACAPizza.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
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
        userEntity.setOrders(user.getOrders().stream().map(o -> orderModelToOrderEntity(o)).collect(Collectors.toList()));
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
        user.setOrders(userEntity.getOrders().stream().map(o -> orderEntityToOrderModel(o)).collect(Collectors.toList()));
        user.setAuthorities("ROLE_USER");
        user.setNon_expired(userEntity.getAccountNonExpired());
        user.setEnabled(userEntity.getEnable());
        user.setCredentials_non_expired(userEntity.getAccountNonExpired());
        user.setNon_locked(userEntity.getAccountNonLocked());

        return user;
    }

    public PizzaEntity pizzaModelTopizzaEntity(Pizza pizza) {

        PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaEntity.setPizzaId(pizza.getPizzaId());
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

        pizzaEntity.setIngredients(ingredients);


        return pizzaEntity;

    }

    public Pizza pizzaEntityToPizzaModel(PizzaEntity pizzaEntity) {

        Pizza pizza = new Pizza();
        pizza.setPizzaId(pizzaEntity.getPizzaId());
        pizza.setName(pizzaEntity.getName());
        pizza.setDescription(pizzaEntity.getDescription());
        pizza.setIscomposed(pizzaEntity.isIscomposed());
        pizza.setPrice(pizzaEntity.getPrice());


        pizza.setSize(pizzaEntity.getSize());
        pizza.setIngredients(pizzaEntity.getIngredients()
                .stream()


                .map(this::ingredientEntityToingredientModel)
                .collect(Collectors.toSet()));

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

    public OrderEntity orderModelToOrderEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(order.getOrderId());
        orderEntity.setClient(this.userModelToUserEntity(order.getClient()));
        orderEntity.setDate(order.getDate());
        orderEntity.setPaid(order.getPaid());
        orderEntity.setCommandeLine(order.getCommandeLine().stream().map(o -> orderPizzaModelToOrderPizzaEntity(o)).collect(Collectors.toList()));

        return orderEntity;
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity) {
        Order order = new Order();
        order.setOrderId(orderEntity.getOrderId());
        order.setClient(this.userEntityToUserModel(orderEntity.getClient()));
        order.setDate(orderEntity.getDate());
        order.setPaid(orderEntity.getPaid());
        order.setCommandeLine(orderEntity.getCommandeLine().stream().map(o -> orderPizzaEntityToOrderPizzaModel(o)).collect(Collectors.toList())
        );
        return order;
    }

    public  OrderPizzaEntity orderPizzaModelToOrderPizzaEntity (OrderPizza orderPizza){
        OrderPizzaEntity orderPizzaEntity = new OrderPizzaEntity();

        orderPizzaEntity.setId(orderPizza.getId());
        orderPizzaEntity.setQuantity(orderPizza.getQuantity());
        orderPizzaEntity.setPizza(this.pizzaModelTopizzaEntity(orderPizza.getPizza()));
        orderPizzaEntity.setOrder(this.orderModelToOrderEntity(orderPizza.getOrder()));
        return orderPizzaEntity;
    }

    public  OrderPizza orderPizzaEntityToOrderPizzaModel (OrderPizzaEntity orderPizzaEntity){
        OrderPizza orderPizza = new OrderPizza();

        orderPizza.setId(orderPizzaEntity.getId());
        orderPizza.setQuantity(orderPizzaEntity.getQuantity());
        orderPizza.setPizza(this.pizzaEntityToPizzaModel(orderPizzaEntity.getPizza()));
        orderPizza.setOrder(this.orderEntityToOrderModel(orderPizzaEntity.getOrder()));
        return orderPizza;
    }


}
