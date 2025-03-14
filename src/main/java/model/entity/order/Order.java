package model.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.entity.product.Products;
import model.entity.user.Users;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private long oderId;
    private Users userId;
    private BigDecimal totalAmount;
    private OrderStatus orderStatus = OrderStatus.PENDING;
    private Date createdAt;
    //manyTo one
    private Users user;
    //manyTo many
    private List<Products> products;
}
