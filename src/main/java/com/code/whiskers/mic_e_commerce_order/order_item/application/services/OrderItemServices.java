package com.code.whiskers.mic_e_commerce_order.order_item.application.services;

import com.code.whiskers.mic_e_commerce_order.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_order.order_item.application.port.in.OrderItemPortIn;
import com.code.whiskers.mic_e_commerce_order.order_item.application.port.out.OrderItemPortOut;
import com.code.whiskers.mic_e_commerce_order.order_item.domain.entities.OrderItem;

import java.util.List;

public class OrderItemServices implements OrderItemPortIn {

    private final OrderItemPortOut orderItemPortOut;

    public OrderItemServices(OrderItemPortOut orderItemPortOut) {
        this.orderItemPortOut = orderItemPortOut;
    }

    @Override
    public ResultResponse<OrderItem> consult(int page, int size, String search, String filter) {
        return this.orderItemPortOut.consult(page,size,search,filter);
    }

    @Override
    public OrderItem show(Long id) {
        return this.orderItemPortOut.show(id);
    }

    @Override
    public List<OrderItem> consultOrderId(Long orderId) {
        return this.orderItemPortOut.consultOrderId(orderId);
    }

    @Override
    public OrderItem create(OrderItem orderItem) {
        return this.orderItemPortOut.create(orderItem);
    }

    @Override
    public OrderItem update(OrderItem orderItem, Long id) {
        return orderItemPortOut.update(orderItem, id);
    }

    @Override
    public OrderItem delete(Long id) {
        return orderItemPortOut.delete(id);
    }
}
