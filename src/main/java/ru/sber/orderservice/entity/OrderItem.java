package ru.sber.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders_item")
@Builder
@Schema(description = "Order item model information")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Product name")
    @Column(name = "name_product", nullable = false)
    private String nameProduct;

    @Schema(description = "Quantity of products")
    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Schema(description = "Description of products")
    @Column(name = "description")
    private String description;

    @Schema(description = "Product price")
    @Column(name = "price", nullable = false)
    private long price;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return getQuantity() == orderItem.getQuantity()
                && getPrice() == orderItem.getPrice()
                && Objects.equals(getId(), orderItem.getId())
                && Objects.equals(getNameProduct(), orderItem.getNameProduct())
                && Objects.equals(getDescription(), orderItem.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNameProduct(), getQuantity(), getDescription(), getPrice());
    }
}
