package eu.busi.ACAPizza.model;

import java.util.ArrayList;
import java.util.Collection;

public class Category {



    private String name;

    private Collection<Pizza> pizzas= new ArrayList<>();

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Collection<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}

