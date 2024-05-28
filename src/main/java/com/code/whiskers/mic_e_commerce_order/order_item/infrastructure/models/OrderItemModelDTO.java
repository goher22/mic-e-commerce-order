package com.code.whiskers.mic_e_commerce_order.order_item.infrastructure.models;

import com.code.whiskers.mic_e_commerce_order.order_item.domain.entities.OrderItem;
import jakarta.persistence.*;


@Entity
@Table(name = "order_items")
public class OrderItemModelDTO extends OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
    private String product;
    private Integer quantity;
    private Double price;

    public OrderItemModelDTO(){
        super();
    }

    public OrderItemModelDTO(Long orderId, String product, Integer quantity, Double price) {
        super(orderId, product,quantity, price);
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItemModelDTO(Long id, Long orderId, String product, Integer quantity, Double price){
        super(id, orderId, product,quantity, price);
        this.id = id;
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public Long getId() {
        return id;
    }


    @Override
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
