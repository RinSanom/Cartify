package model.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.entity.user.Users;

import java.math.BigDecimal;
import java.sql.Date;
@Data
@AllArgsConstructor
public class Order {
    private long oderId;
    private Users userId;
    private BigDecimal totalAmount;
    private OrderStatus orderStatus = OrderStatus.PENDING;
    private Date createdAt;
}
