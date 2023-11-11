package ru.sber.orderservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Response order creation")
public class ResponseMsg {
    @Schema(description = "Order id")
    private Long orderId;

    @Schema(description = "message")
    private String message;
}
