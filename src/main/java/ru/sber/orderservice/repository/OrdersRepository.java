package ru.sber.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sber.orderservice.entity.Order;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {

}
