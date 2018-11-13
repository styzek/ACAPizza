package eu.busi.ACAPizza.model;

import java.util.List;

public class Ingredient {

    private int ingredientId;
    private int stock;
    private String name;
    private boolean isCheckd;
    List<Pizza> pizzas;

    public Ingredient() {
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

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public boolean isCheckd() {
        return isCheckd;
    }

    public void setCheckd(boolean checkd) {
        isCheckd = checkd;
    }
}
