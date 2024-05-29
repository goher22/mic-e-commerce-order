package com.code.whiskers.mic_e_commerce_order.order.infrastructure.services;

import com.code.whiskers.mic_e_commerce_order.common.domain.PageDomain;
import com.code.whiskers.mic_e_commerce_order.common.domain.ResultResponse;
import com.code.whiskers.mic_e_commerce_order.order.application.port.out.OrderPortOut;
import com.code.whiskers.mic_e_commerce_order.order.domain.entities.Order;
import com.code.whiskers.mic_e_commerce_order.order.infrastructure.models.OrderModelDTO;
import com.code.whiskers.mic_e_commerce_order.order.infrastructure.repositories.OrderRepositoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderMysqlAdapter implements OrderPortOut {

    @Autowired
    private OrderRepositoryDTO orderRepositoryDTO;

    @Override
    public ResultResponse<Order> consult(int page, int size, String search, String filter) {
        try{
            Page<OrderModelDTO> productPage = orderRepositoryDTO.findAll(PageRequest.of(page, size));
            List<OrderModelDTO> products = productPage.getContent();

            List<Order> orderList = products.stream()
                    .map(orderModelDTO -> new Order(
                                orderModelDTO.getId(),
                                orderModelDTO.getDocumentUser(),
                                orderModelDTO.getNameUser(),
                                orderModelDTO.getOrderDate()
                            )
                    ).toList();
            PageDomain pageDomain = new PageDomain(
                    productPage.getTotalPages(),
                    size,
                    page,
                    "/api/order"
            );
            return new ResultResponse<>(pageDomain, orderList);
        }catch (Exception e){
            throw  e;
        }
    }

    @Override
    public Order show(Long id) {
        Optional<OrderModelDTO> optionalProduct = orderRepositoryDTO.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public Order create(Order order) {
        return orderRepositoryDTO.save(new OrderModelDTO(
                    order.getDocumentUser(),
                    order.getNameUser(),
                    order.getOrderDate()
                )
        );
    }

    @Override
    public Order update(Order order, Long id) {
        Optional<OrderModelDTO> optionalProduct = orderRepositoryDTO.findById(id);
        if(optionalProduct.isPresent()){
            OrderModelDTO editOrder = optionalProduct.get();
            editOrder.setDocumentUser(order.getDocumentUser());
            editOrder.setNameUser(order.getNameUser());
            editOrder.setOrderDate(order.getOrderDate());

            return orderRepositoryDTO.save(editOrder);
        }
        return null;
    }

    @Override
    public Order delete(Long id) {
        Optional<OrderModelDTO> optionalProduct = orderRepositoryDTO.findById(id);
        if(optionalProduct.isPresent()){
            orderRepositoryDTO.deleteById(id);
            return optionalProduct.get();
        }
        return null;
    }
}
