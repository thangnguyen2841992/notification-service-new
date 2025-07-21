package com.regain.notification_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageOrder {
    private int userId;
    private String fullName;
    private String toEmail;
    private  int gender;
    private int totalProduct;
    private double totalPrice;
    private int orderId;
}