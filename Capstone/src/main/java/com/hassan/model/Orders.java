package com.hassan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private long id;
    private String orderTrackingNumber;
    private BigDecimal totalPrice;
    private int totalQuantity;
    private long billingAddressId;
    private long customerId;
    private long shippingAddressId;
    private String status;
    private Date dateCreated;
    private Date lastUpdated;

}
