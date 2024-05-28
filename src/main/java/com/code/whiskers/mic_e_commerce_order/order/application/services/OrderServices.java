package com.code.whiskers.mic_e_commerce_order.order.application.services;

import com.code.whiskers.mic_e_commerce_order.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_order.order.application.port.in.OrderPortIn;
import com.code.whiskers.mic_e_commerce_order.order.application.port.out.OrderPortOut;
import com.code.whiskers.mic_e_commerce_order.order.domain.entities.Order;

public class OrderServices implements OrderPortIn {


    private final OrderPortOut orderPortOut;

    public OrderServices(OrderPortOut orderPortOut) {
        this.orderPortOut = orderPortOut;
    }

    @Override
    public ResultResponse<Order> consult(int page, int size, String search, String filter) {
        return this.orderPortOut.consult(page, size, search, filter);
    }

    @Override
    public Order show(Long id) {
        return this.orderPortOut.show(id);
    }

    @Override
    public Order create(Order order) {
        return this.orderPortOut.create(order);
    }

    @Override
    public Order update(Order order, Long id) {
        return this.orderPortOut.update(order, id);
    }

    @Override
    public Order delete(Long id) {
        return this.orderPortOut.delete(id);
    }
}
