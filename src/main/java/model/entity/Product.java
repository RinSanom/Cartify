package model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int productId;
    private int categoryId;
    private String name;
    private double price;
    private int stockQuantity;
    private boolean sold;
    private String description;
    private LocalDateTime createdAt;

}