package eu.busi.ACAPizza.dataAccess.entity;

import eu.busi.ACAPizza.model.Ingredient;

import javax.persistence.*;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Entity
@Table(name="pizza")
public class PizzaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pizzaId", unique = true, nullable = false)
    private int pizzaId;

    @Column(name="name")
    private String name;

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
    private Set<IngredientEntity> ingredients;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="pizza_category",
            joinColumns = {@JoinColumn(name = "fk_pizzaId",referencedColumnName = "pizzaId")},
            inverseJoinColumns = {@JoinColumn(name = "fk_categoryId",referencedColumnName = "name")}

    )
    private List<CategoryEntity> categories;


    public PizzaEntity() {}

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientEntity> ingredients) {
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

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }
}
