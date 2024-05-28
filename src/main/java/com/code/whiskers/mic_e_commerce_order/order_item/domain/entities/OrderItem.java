package com.code.whiskers.mic_e_commerce_order.order_item.domain.entities;

public class OrderItem {

    private Long id;
    private Long orderId;
    private String product;
    private Integer quantity;
    private Double price;

    public OrderItem(){

    }

    public OrderItem(Long orderId, String product, Integer quantity, Double price){
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem(Long id, Long orderId, String product, Integer quantity, Double price){
        this.id = id;
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

}
