package eu.busi.ACAPizza.model;

import java.util.HashMap;
import java.util.Map;

public class Panier {

    private Pizza pizza;
    private int quantité;

   private Map<Pizza,Integer> panier = new HashMap<>();


    public Panier() {
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public Map<Pizza, Integer> getPanier() {
        return panier;
    }

    public void setPanier(Map<Pizza, Integer> panier) {
        this.panier = panier;
    }
}
