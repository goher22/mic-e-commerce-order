package com.code.whiskers.mic_e_commerce_order.order.domain.entities;

import javax.xml.crypto.Data;
import java.util.Date;

public class Order {

    private Long id;

    private Long documentUser;

    private String nameUser;

    private Date orderDate;

    public Order() {

    }

    public Order(Long documentUser, String nameUser, Date orderDate){
        this.documentUser = documentUser;
        this.nameUser = nameUser;
        this.orderDate = orderDate;
    }

    public Order(Long id, Long documentUser, String nameUser, Date orderDate){
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

    public Date getOrderDate() {
        return orderDate;
    }
}
