package eu.busi.ACAPizza.dataAccess.entity;

import eu.busi.ACAPizza.model.Pizza;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ingredient")
public class IngredientEntity {

    @Id
    @Column(name="ingredientId")
    private int ingredientId;
    @Column(name="stock")
    private int stock;
    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    List<PizzaEntity> pizzas;

    public IngredientEntity() {
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PizzaEntity> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<PizzaEntity> pizzas) {
        this.pizzas = pizzas;
    }
}
