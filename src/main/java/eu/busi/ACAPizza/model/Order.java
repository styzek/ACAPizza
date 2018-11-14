package eu.busi.ACAPizza.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Order {

    private int orderId;
    private User client;
    private LocalDateTime date;
    private List<OrderPizza> commandeLine;
    private Boolean isPaid;

    public Order() {}

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }


    public List<OrderPizza> getCommandeLine() {
        return commandeLine;
    }

    public void setCommandeLine(List<OrderPizza> commandeLine) {
        this.commandeLine = commandeLine;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
