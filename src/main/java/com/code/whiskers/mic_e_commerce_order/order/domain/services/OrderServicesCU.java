package com.code.whiskers.mic_e_commerce_order.order.domain.services;

import com.code.whiskers.mic_e_commerce_order.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_order.order.domain.entities.Order;
import org.springframework.http.ResponseEntity;

public interface OrderServicesCU {
    public ResponseEntity<ResultResponse<Order>> getAllOrders(int page, int size, String search, String filter);
    public ResponseEntity<Order> getOrder(Long id);
    public ResponseEntity<Order> postOrder(Order order);
    public ResponseEntity<Order> putOrder(Order order, Long id);
}
