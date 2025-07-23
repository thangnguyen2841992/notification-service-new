package com.regain.notification_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageOrderResponse {
    private String toEmail;
    private String message;
    private int orderId;
    private String fullName;
}
