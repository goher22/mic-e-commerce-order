package com.code.whiskers.mic_e_commerce_order.order_item.infrastructure.repositories;

import com.code.whiskers.mic_e_commerce_order.order_item.infrastructure.models.OrderItemModelDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepositoryDTO extends JpaRepository<OrderItemModelDTO, Long> {
}
