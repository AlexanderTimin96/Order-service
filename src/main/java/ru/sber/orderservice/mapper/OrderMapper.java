package ru.sber.orderservice.mapper;

import ru.sber.orderservice.DTO.OrderDTO;
import ru.sber.orderservice.entity.Order;

public interface OrderMapper {
    Order orderDTOtoOrder(OrderDTO orderDTO);
}
