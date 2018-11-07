package eu.busi.ACAPizza.model;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Order {

    private User client;
    private LocalDateTime date;
    List<OrderPizza> pizzas;

    public Order() {}

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public List<OrderPizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<OrderPizza> pizzas) {
        this.pizzas = pizzas;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
