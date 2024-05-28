package com.code.whiskers.mic_e_commerce_order.order.domain.entities;

import javax.xml.crypto.Data;

public class Order {

    private Long id;

    private Long documentUser;

    private String nameUser;

    private Data orderDate;

    public Order() {

    }

    public Order(Long documentUser, String nameUser, Data orderDate){
        this.documentUser = documentUser;
        this.nameUser = nameUser;
        this.orderDate = orderDate;
    }

    public Order(Long id, Long documentUser, String nameUser, Data orderDate){
        this.id = id;
        this.documentUser = documentUser;
        this.nameUser = nameUser;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public Long getDocumentUser() {
        return documentUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public Data getOrderDate() {
        return orderDate;
    }
}
