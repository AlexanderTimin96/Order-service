package ru.sber.orderservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.sber.orderservice.DTO.OrderDTO;
import ru.sber.orderservice.entity.Order;
import ru.sber.orderservice.model.ResponseMsg;
import ru.sber.orderservice.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Tag(name = "REST API for order",
        description = "REST APIs for order - Create order, Get all order")
public class OrderController {
    private final OrderService orderService;


    @Operation(summary = "Get all user REST API",
            description = "Get all user REST API is used to get all user in a database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrder() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @Operation(summary = "Create order REST API",
            description = "Create order REST API is used to save user in a database")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "400", description = "HTTP Status 400 BAD REQUEST",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @PostMapping()
    public ResponseEntity<ResponseMsg> createdOrder(@Validated @RequestBody OrderDTO orderDTO) {
        Order createdOrder = orderService.createdOrder(orderDTO);
        return new ResponseEntity<>(new ResponseMsg(createdOrder.getId(), "Order was successfully created"),
                HttpStatus.CREATED);
    }
}
