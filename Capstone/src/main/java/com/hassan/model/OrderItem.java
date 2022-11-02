package com.hassan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderItem {
    private long id;
    private String imageUrl;
    private int quantity;
    private BigDecimal unitPrice;
    private long orderId;
    private long productId;
}
