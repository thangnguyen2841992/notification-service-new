package com.regain.notification_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageActiveResponse {
    private int toUserId;

    private String toUserEmail;

    private String toUserName;

    private String toUserFullName;
}
