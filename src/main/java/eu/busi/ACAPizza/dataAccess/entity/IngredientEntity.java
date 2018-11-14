package eu.busi.ACAPizza.dataAccess.entity;

import eu.busi.ACAPizza.model.Pizza;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="ingredient")
public class IngredientEntity {

    @Id
    @Column(name="ingredientId")
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IngredientEntity)) return false;
        IngredientEntity that = (IngredientEntity) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

}
