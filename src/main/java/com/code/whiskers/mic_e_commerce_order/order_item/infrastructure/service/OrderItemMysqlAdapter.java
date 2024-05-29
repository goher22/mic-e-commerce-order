package com.code.whiskers.mic_e_commerce_order.order_item.infrastructure.service;

import com.code.whiskers.mic_e_commerce_order.common.domain.PageDomain;
import com.code.whiskers.mic_e_commerce_order.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_order.order_item.application.port.out.OrderItemPortOut;
import com.code.whiskers.mic_e_commerce_order.order_item.domain.entities.OrderItem;
import com.code.whiskers.mic_e_commerce_order.order_item.infrastructure.models.OrderItemModelDTO;
import com.code.whiskers.mic_e_commerce_order.order_item.infrastructure.repositories.OrderItemRepositoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemMysqlAdapter implements OrderItemPortOut {

    @Autowired
    private OrderItemRepositoryDTO orderItemRepositoryDTO;

    @Override
    public ResultResponse<OrderItem> consult(int page, int size, String search, String filter) {
        try{
            Page<OrderItemModelDTO> orderItemPage = orderItemRepositoryDTO.findAll(PageRequest.of(page, size));
            List<OrderItemModelDTO> orderItems = orderItemPage.getContent();

            List<OrderItem> orderItemtList = orderItems.stream()
                    .map(orderItemModelDTO -> new OrderItem(
                                orderItemModelDTO.getId(),
                                orderItemModelDTO.getOrderId(),
                                orderItemModelDTO.getProduct(),
                                orderItemModelDTO.getQuantity(),
                                orderItemModelDTO.getPrice()
                            )
                    ).toList();
            PageDomain pageDomain = new PageDomain(
                    orderItemPage.getTotalPages(),
                    size,
                    page,
                    "/api/order_item"
            );
            return new ResultResponse<>(pageDomain, orderItemtList);
        }catch (Exception e){
            throw  e;
        }
    }

    @Override
    public List<OrderItem> consultOrderId(Long orderId) {
        List<OrderItemModelDTO> orderItems = orderItemRepositoryDTO.findByOrderId(orderId);

        return orderItems.stream()
                .map(orderItemModelDTO -> new OrderItem(
                                orderItemModelDTO.getId(),
                                orderItemModelDTO.getOrderId(),
                                orderItemModelDTO.getProduct(),
                                orderItemModelDTO.getQuantity(),
                                orderItemModelDTO.getPrice()
                        )
                ).toList();
    }

    @Override
    public OrderItem show(Long id) {
        Optional<OrderItemModelDTO> optionalProduct = orderItemRepositoryDTO.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public OrderItem create(OrderItem orderItem) {
        return orderItemRepositoryDTO.save(new OrderItemModelDTO(
                orderItem.getOrderId(),
                orderItem.getProduct(),
                orderItem.getQuantity(),
                orderItem.getPrice()
            )
        );
    }

    @Override
    public OrderItem update(OrderItem orderItem, Long id) {
        Optional<OrderItemModelDTO> optionalProduct = orderItemRepositoryDTO.findById(id);
        if(optionalProduct.isPresent()){
            OrderItemModelDTO editOrderItem = optionalProduct.get();
            editOrderItem.setOrderId(orderItem.getOrderId());
            editOrderItem.setProduct(orderItem.getProduct());
            editOrderItem.setQuantity(orderItem.getQuantity());
            editOrderItem.setPrice(orderItem.getPrice());
            return orderItemRepositoryDTO.save(editOrderItem);
        }
        return null;
    }

    @Override
    public OrderItem delete(Long id) {
        Optional<OrderItemModelDTO> optionalProduct = orderItemRepositoryDTO.findById(id);
        if(optionalProduct.isPresent()){
            orderItemRepositoryDTO.deleteById(id);
            return optionalProduct.get();
        }
        return null;
    }
}
