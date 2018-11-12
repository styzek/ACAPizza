package eu.busi.ACAPizza.model;

import java.util.List;
import java.util.Objects;

public class Pizza {


    private int pizzaId;
    private String name;
    private String description;
    private String size;
    private float price;
    private boolean iscomposed;

    private List<OrderPizza> orders;

    private List<Ingredient> ingredients;

    private List<Category> categories;

    public Pizza() {
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                '}';
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isIscomposed() {
        return iscomposed;
    }

    public void setIscomposed(boolean iscomposed) {
        this.iscomposed = iscomposed;
    }

    public List<OrderPizza> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderPizza> orders) {
        this.orders = orders;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return pizzaId == pizza.pizzaId &&
                Objects.equals(name, pizza.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizzaId, name);
    }
}
