package com.example.springultimate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Orders {

    @JsonProperty("order_name")
    private String orderName;
    @JsonProperty("order_type")
    private String orderType;
    @JsonProperty("order_quantity")
    private int orderQuantity;

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderName='" + orderName + '\'' +
                ", orderType='" + orderType + '\'' +
                ", orderQuantity=" + orderQuantity +
                '}';
    }
}
