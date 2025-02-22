package model.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.entity.product.Products;

@Data
@AllArgsConstructor
public class OrderItems {
    private long itemId;
    private Order orderId;
    private Products productId;
    private int quantity;
}
