package com.regain.notification_service.service;


import com.regain.notification_service.model.MessageSendActiveUser;

public interface INotificationService {
    void sendEmailActive(MessageSendActiveUser messageSendActiveUser);
}
