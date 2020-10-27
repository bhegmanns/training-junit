package de.hegmanns.training.junit5.parameter.order;

public class Order {

    private Orderzusatz orderzusatz;
    private OrderType orderType;

    public Orderzusatz getOrderzusatz() {
        return orderzusatz;
    }

    public void setOrderzusatz(Orderzusatz orderzusatz) {
        this.orderzusatz = orderzusatz;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }
}
