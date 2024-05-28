package com.code.whiskers.mic_e_commerce_order.order.infrastructure.models;

import com.code.whiskers.mic_e_commerce_order.order.domain.entities.Order;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class OrderModelDTO extends Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "document_user")
    private Long documentUser;
    @Column(name = "name_user")
    private String nameUser;
    @Column(name = "order_date")
    private Date orderDate;

    public OrderModelDTO(){
        super();
    }

    public OrderModelDTO(Long documentUser, String nameUser, Date orderDate) {
        super(documentUser, nameUser, orderDate);
        this.documentUser =documentUser;
        this.nameUser = nameUser;
        this.orderDate = orderDate;
    }

    public OrderModelDTO(Long id, Long documentUser, String nameUser, Date orderDate) {
        super(id, documentUser, nameUser, orderDate);
        this.id = id;
        this.documentUser =documentUser;
        this.nameUser = nameUser;
        this.orderDate = orderDate;
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
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
