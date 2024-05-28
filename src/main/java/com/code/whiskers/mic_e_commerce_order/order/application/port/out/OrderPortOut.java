package com.code.whiskers.mic_e_commerce_order.order.application.port.out;

import com.code.whiskers.mic_e_commerce_order.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_order.order.domain.entities.Order;

public interface OrderPortOut {
    public ResultResponse<Order> consult(int page, int size, String search, String filter);
    public Order show(Long id);
    public Order create(Order order);
    public Order update(Order order, Long id);
    public Order delete(Long id);
}
