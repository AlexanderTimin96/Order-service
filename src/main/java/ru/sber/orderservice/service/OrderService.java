package ru.sber.orderservice.service;

import ru.sber.orderservice.DTO.OrderDTO;
import ru.sber.orderservice.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Order createdOrder(OrderDTO orderDTO);
}
