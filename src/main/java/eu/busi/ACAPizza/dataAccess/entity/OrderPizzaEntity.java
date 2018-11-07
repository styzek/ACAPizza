package eu.busi.ACAPizza.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="order_pizza")
public class OrderPizzaEntity {

    @Id
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "fk_orderId",referencedColumnName = "orderId")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "fk_pizzaId",referencedColumnName = "pizzaId")
    private PizzaEntity pizza;

    @Column(name="quantity")
    private int quantity;

    public OrderPizzaEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public PizzaEntity getPizza() {
        return pizza;
    }

    public void setPizza(PizzaEntity pizza) {
        this.pizza = pizza;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
