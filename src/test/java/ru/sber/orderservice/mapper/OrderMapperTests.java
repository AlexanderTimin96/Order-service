package ru.sber.orderservice.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sber.orderservice.DataForTest;
import ru.sber.orderservice.entity.Order;

@SpringBootTest
public class OrderMapperTests {
    @Autowired
    OrderMapper orderMapper;
    DataForTest data = new DataForTest();

    @Test
    public void OrderDTOtoOrderTest_thenSuccess() {
        Order expected = data.getOrder();

        Order result = orderMapper.orderDTOtoOrder(data.getOrderDTO());

        Assertions.assertEquals(expected.getTotalPrice(), result.getTotalPrice());
        Assertions.assertEquals(expected.getUserId(), result.getUserId());
        Assertions.assertEquals(expected.getItems(), result.getItems());
    }

}
