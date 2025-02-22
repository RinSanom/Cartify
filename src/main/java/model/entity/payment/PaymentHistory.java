package model.entity.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.entity.order.Order;

import java.math.BigDecimal;
import java.sql.Date;
@Data
@AllArgsConstructor
public class PaymentHistory {
    private Payment paymentID;
    private Order orderId;
    private BigDecimal amount;
    private String paymentMethod = "BakongPay";
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
    private Date transactionDate;
}
