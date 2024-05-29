package com.code.whiskers.mic_e_commerce_order.order_item.application.port.in;

import com.code.whiskers.mic_e_commerce_order.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_order.order_item.domain.entities.OrderItem;

import java.util.List;

public interface OrderItemPortIn {

    public ResultResponse<OrderItem> consult(int page, int size, String search, String filter);
    public OrderItem show(Long id);
    public List<OrderItem> consultOrderId(Long orderId);
    public OrderItem create(OrderItem orderItem);
    public OrderItem update(OrderItem orderItem, Long id);
    public OrderItem delete(Long id);

}
