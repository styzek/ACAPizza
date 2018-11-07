package eu.busi.ACAPizza.dataAccess.entity;

import eu.busi.ACAPizza.model.Ingredient;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="pizza")
public class PizzaEntity {

    @Id
    @Column(name="pizzaId")
    private int pizzaId;
    @Column(name="description")
    private String description;

    private String size;

    @Column(name="price")
    private float price;

    private boolean iscomposed;

    @OneToMany(mappedBy ="pizza", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<OrderPizzaEntity>orders;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="pizza_ingredient",
            joinColumns = {@JoinColumn(name = "fk_pizzaId",referencedColumnName = "pizzaId")},
            inverseJoinColumns = {@JoinColumn(name = "fk_ingredientId",referencedColumnName = "ingredientId")}

    )
    private List<IngredientEntity> ingredients;

    public PizzaEntity() {}

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

    public List<OrderPizzaEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderPizzaEntity> orders) {
        this.orders = orders;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isIscomposed() {
        return iscomposed;
    }

    public void setIscomposed(boolean iscomposed) {
        this.iscomposed = iscomposed;
    }
}
