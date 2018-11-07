package eu.busi.ACAPizza.dataAccess.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="commande")
public class OrderEntity {


    @Id
    @Column(name="orderId")
    private int orderId;

    @Column(name="date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "fk_client",referencedColumnName = "userId")
    private UserEntity client;

    @OneToMany(mappedBy ="order", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<OrderPizzaEntity> pizzas;

    public OrderEntity() {}

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public UserEntity getClient() {
        return client;
    }
    public void setClient(UserEntity client) {
        this.client = client;
    }

    public List<OrderPizzaEntity> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<OrderPizzaEntity> pizzas) {
        this.pizzas = pizzas;
    }
}
