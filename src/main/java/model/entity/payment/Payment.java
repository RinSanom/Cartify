package model.entity.payment;

import model.entity.user.Users;

import java.math.BigDecimal;
import java.sql.Date;

public class Payment {
    private long paymentId;
    private Users userId;
    private BigDecimal amount;
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
    private String paymentMethod = "BakongPay";
    private Date createdAt;
    private Date updatedAt;
}
