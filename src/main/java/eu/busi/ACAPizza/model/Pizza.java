package eu.busi.ACAPizza.model;

import java.util.List;

public class Pizza {


    private String description;

    private String size;

    private float price;

    private boolean iscomposed;

    private List<OrderPizza> orders;

    private List<Ingredient> ingredients;

    public Pizza() {
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
}
