package ru.sber.orderservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.sber.orderservice.DataForTest;
import ru.sber.orderservice.entity.Order;
import ru.sber.orderservice.mapper.OrderMapper;
import ru.sber.orderservice.repository.OrdersRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrderServiceTests {
    DataForTest data = new DataForTest();
    @Autowired
    private OrderService orderService;
    @MockBean
    private OrdersRepository ordersRepository;
    @MockBean
    private OrderMapper orderMapper;

    @Test
    public void createOrder_thenSuccess() {
        Mockito.when(orderMapper.orderDTOtoOrder(data.getOrderDTO())).thenReturn(data.getOrder());
        Mockito.when(ordersRepository.save(data.getOrder())).thenReturn(data.getOrder());

        orderService.createdOrder(data.getOrderDTO());

        Mockito.verify(orderMapper, Mockito.times(1)).orderDTOtoOrder(data.getOrderDTO());
        Mockito.verify(ordersRepository, Mockito.times(1)).save(data.getOrder());
    }

    @Test
    public void getAllOrder_thenSuccess() {
        Mockito.when(ordersRepository.findAll()).thenReturn(data.getListOrder());

        orderService.getAllOrders();

        Mockito.verify(ordersRepository, Mockito.times(1)).findAll();
    }

}
