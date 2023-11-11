package ru.sber.orderservice.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Schema(description = "OrderItemDTO model information")
@Data
@Builder
public class OrderItemDTO {

    @Schema(description = "Product name")
    @NotBlank(message = "Product name should not be null or empty")
    private String nameProduct;

    @Schema(description = "Quantity of products")
    @Min(value = 1, message = "Quantity must be more than or equal to 100")
    private int quantity;

    @Schema(description = "Description of products")
    private String description;

    @Schema(description = "Product price")
    @Min(value = 100, message = "Price must be more than or equal to 100")
    private long price;
}
