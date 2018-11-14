package eu.busi.ACAPizza.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Pizza {


    private int pizzaId;
    private String name;
    private String description;
    private String size;
    private float price;
    private boolean iscomposed;

    private List<OrderPizza> orders;

    private List<String> ingredientsString;
    private Set<Ingredient> ingredients;
    private List<Category> categories;

    public Pizza() {
    }

//    public Pizza(List<String> ingredientsString) {
//        this.ingredientsString = ingredientsString;
//        for (String s: ingredientsString){
//            ingredients.stream()
//        }
//    }

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

    public List<String> getIngredientsString() {
        return ingredientsString;
    }

    public void setIngredientsString(List<String> ingredientsString) {
        this.ingredientsString = ingredientsString;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
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
        if (!(o instanceof Pizza)) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(getIngredients(), pizza.getIngredients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIngredients());
    }
}
