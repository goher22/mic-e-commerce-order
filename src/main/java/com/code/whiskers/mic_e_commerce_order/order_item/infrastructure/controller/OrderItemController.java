package com.code.whiskers.mic_e_commerce_order.order_item.infrastructure.controller;

import com.code.whiskers.mic_e_commerce_order.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_order.order_item.application.port.in.OrderItemPortIn;
import com.code.whiskers.mic_e_commerce_order.order_item.application.services.OrderItemServices;
import com.code.whiskers.mic_e_commerce_order.order_item.domain.entities.OrderItem;
import com.code.whiskers.mic_e_commerce_order.order_item.domain.services.OrderItemServicesCU;
import com.code.whiskers.mic_e_commerce_order.order_item.infrastructure.service.OrderItemMysqlAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order_item")
public class OrderItemController implements OrderItemServicesCU {

    private final OrderItemPortIn orderItemPortIn;

    public OrderItemController(OrderItemMysqlAdapter orderItemMysqlAdapter) {
        this.orderItemPortIn = new OrderItemServices(orderItemMysqlAdapter);
    }

    @Override
    @GetMapping
    public ResponseEntity<ResultResponse<OrderItem>> getAllOrdersItems(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String search,
            @RequestParam String filter) {
        ResultResponse<OrderItem> order = this.orderItemPortIn.consult(page,size,search,filter);
        return ResponseEntity.ok(order);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItem(@PathVariable Long id) {
        OrderItem  orderItem = orderItemPortIn.show(id);
        if(orderItem != null){
            return ResponseEntity.ok(orderItem);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @PostMapping
    public ResponseEntity<OrderItem> postOrderItem(@RequestBody OrderItem orderItem) {
        try{
            OrderItem createOrder = orderItemPortIn.create(orderItem);
            return ResponseEntity.status(HttpStatus.CREATED).body(createOrder);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> putOrderItem(@RequestBody OrderItem orderItem, @PathVariable Long id) {
        OrderItem updateOrder = orderItemPortIn.update(orderItem, id);
        if(updateOrder != null) {
            return ResponseEntity.ok(updateOrder);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
