package com.code.whiskers.mic_e_commerce_order.order.infrastructure.controller;

import com.code.whiskers.mic_e_commerce_order.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_order.order.application.port.in.OrderPortIn;
import com.code.whiskers.mic_e_commerce_order.order.application.services.OrderServices;
import com.code.whiskers.mic_e_commerce_order.order.domain.entities.Order;
import com.code.whiskers.mic_e_commerce_order.order.domain.services.OrderServicesCU;
import com.code.whiskers.mic_e_commerce_order.order.infrastructure.services.OrderMysqlAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController implements OrderServicesCU {

    private final OrderPortIn orderPortIn;

    public OrderController(OrderMysqlAdapter orderMysqlAdapter){
        this.orderPortIn = new OrderServices(orderMysqlAdapter);
    }

    @Override
    @GetMapping
    public ResponseEntity<ResultResponse<Order>> getAllOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String filter) {
        ResultResponse<Order> order = this.orderPortIn.consult(page,size,search,filter);

        return ResponseEntity.ok(order);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        Order  order = orderPortIn.show(id);
        if(order != null){
            return ResponseEntity.ok(order);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @PostMapping
    public ResponseEntity<Order> postOrder(@RequestBody Order order) {
        try{
            Order createOrder = orderPortIn.create(order);
            return ResponseEntity.status(HttpStatus.CREATED).body(createOrder);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Order> putOrder(Order order, Long id) {
        Order updateOrder = orderPortIn.update(order, id);
        if(updateOrder != null) {
            return ResponseEntity.ok(updateOrder);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
