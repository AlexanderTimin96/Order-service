package ru.sber.orderservice.mapper;

import org.springframework.stereotype.Component;
import ru.sber.orderservice.DTO.OrderDTO;
import ru.sber.orderservice.DTO.OrderItemDTO;
import ru.sber.orderservice.entity.Order;
import ru.sber.orderservice.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapperImpl implements OrderMapper {

    public Order orderDTOtoOrder(OrderDTO orderDTO) {
        Order order = new Order();

        long totalPrice = 0;
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemDTO orderItemDTO : orderDTO.getItems()) {
            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .description(orderItemDTO.getDescription())
                    .price(orderItemDTO.getPrice())
                    .nameProduct(orderItemDTO.getNameProduct())
                    .quantity(orderItemDTO.getQuantity())
                    .build();

            totalPrice += orderItemDTO.getPrice() * orderItemDTO.getQuantity();
            orderItems.add(orderItem);
        }
        order.setUserId(orderDTO.getUserId());
        order.setItems(orderItems);
        order.setTotalPrice(totalPrice);
        return order;
    }
}
