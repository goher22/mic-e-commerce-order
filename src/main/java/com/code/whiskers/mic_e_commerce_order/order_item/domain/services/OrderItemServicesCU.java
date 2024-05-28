package com.code.whiskers.mic_e_commerce_order.order_item.domain.services;

import com.code.whiskers.mic_e_commerce_order.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_order.order_item.domain.entities.OrderItem;
import org.springframework.http.ResponseEntity;

public interface OrderItemServicesCU {

    public ResponseEntity<ResultResponse<OrderItem>> getAllOrdersItems(int page, int size, String search, String filter);
    public ResponseEntity<OrderItem> getOrderItem(Long id);
    public ResponseEntity<OrderItem> postOrderItem(OrderItem orderItem);
    public ResponseEntity<OrderItem> putOrderItem(OrderItem orderItem, Long id);

}
