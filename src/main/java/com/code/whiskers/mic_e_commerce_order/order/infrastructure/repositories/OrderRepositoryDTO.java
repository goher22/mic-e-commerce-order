package com.code.whiskers.mic_e_commerce_order.order.infrastructure.repositories;

import com.code.whiskers.mic_e_commerce_order.order.infrastructure.models.OrderModelDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryDTO extends JpaRepository<OrderModelDTO, Long> {
}
