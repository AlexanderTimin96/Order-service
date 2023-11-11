package ru.sber.orderservice;

import ru.sber.orderservice.DTO.OrderDTO;
import ru.sber.orderservice.DTO.OrderItemDTO;
import ru.sber.orderservice.entity.Order;
import ru.sber.orderservice.entity.OrderItem;
import ru.sber.orderservice.model.ResponseMsg;

import java.util.ArrayList;
import java.util.List;

public class DataForTest {
    public OrderDTO getOrderDTO() {
        OrderItemDTO orderItemDTO = OrderItemDTO.builder()
                .nameProduct("product1")
                .quantity(1)
                .description("product1")
                .price(150L)
                .build();

        List<OrderItemDTO> orderItemDTOs = new ArrayList<>();
        orderItemDTOs.add(orderItemDTO);

        return new OrderDTO(1L, orderItemDTOs);
    }

    public Order getOrder() {
        Order order = new Order();

        OrderItem orderItem = OrderItem.builder()
                .order(order)
                .nameProduct("product1")
                .quantity(1)
                .description("product1")
                .price(150L)
                .build();
        List<OrderItem> orderDTOs = new ArrayList<>();
        orderDTOs.add(orderItem);

        order.setId(1L);
        order.setItems(orderDTOs);
        order.setUserId(1L);
        order.setTotalPrice(150L);
        return order;
    }

    public ResponseMsg getResponseMsg() {
        return new ResponseMsg(1L, "Order was successfully created");
    }

    public List<Order> getListOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(getOrder());
        return orders;
    }
}
