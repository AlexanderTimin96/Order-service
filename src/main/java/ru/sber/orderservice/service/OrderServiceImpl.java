package ru.sber.orderservice.service;

import lombok.RequiredArgsConstructor;
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
public class OrderServiceImpl implements OrderService {

    private final OrdersRepository ordersRepository;

    private final OrderMapper orderMapper;

    @Override
    public List<Order> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Order createdOrder(OrderDTO orderDTO) {
        return ordersRepository.save(orderMapper.orderDTOtoOrder(orderDTO));
    }
}
