package eu.busi.ACAPizza.model;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

public class Order {

    private int orderId;
    private int userId;
    private LocalDateTime date;

    public Order() {}

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
