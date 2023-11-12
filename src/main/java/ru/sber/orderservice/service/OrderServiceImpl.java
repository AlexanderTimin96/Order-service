package ru.sber.orderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sber.orderservice.DTO.OrderDTO;
import ru.sber.orderservice.entity.Order;
import ru.sber.orderservice.mapper.OrderMapper;
import ru.sber.orderservice.repository.OrdersRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrdersRepository ordersRepository;

    private final OrderMapper orderMapper;

    @Override
    public List<Order> getAllOrders() {
        log.info("Get list all orders");
        return ordersRepository.findAll();
    }

    @Override
    public Order createdOrder(OrderDTO orderDTO) {
        log.info("Mapped order request {}", orderDTO);
        Order order = orderMapper.orderDTOtoOrder(orderDTO);
        log.info("Save order {}", order);
        return ordersRepository.save(order);
    }
}
