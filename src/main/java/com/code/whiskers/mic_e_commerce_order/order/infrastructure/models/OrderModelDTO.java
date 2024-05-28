package com.code.whiskers.mic_e_commerce_order.order.infrastructure.models;

import com.code.whiskers.mic_e_commerce_order.order.domain.entities.Order;
import jakarta.persistence.*;

import javax.xml.crypto.Data;

@Entity
@Table(name = "orders")
public class OrderModelDTO extends Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long documentUser;
    private String nameUser;
    private Data orderDate;

    public OrderModelDTO(){
        super();
    }

    public OrderModelDTO(Long documentUser, String nameUser, Data orderDate) {
        super(documentUser, nameUser, orderDate);
    }

    public OrderModelDTO(Long id, Long documentUser, String nameUser, Data orderDate) {
        super(id, documentUser, nameUser, orderDate);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Long getDocumentUser() {
        return documentUser;
    }

    public void setDocumentUser(Long documentUser) {
        this.documentUser = documentUser;
    }

    @Override
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    @Override
    public Data getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Data orderDate) {
        this.orderDate = orderDate;
    }
}
