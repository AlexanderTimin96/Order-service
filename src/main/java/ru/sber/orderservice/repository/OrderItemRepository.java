package ru.sber.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sber.orderservice.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
