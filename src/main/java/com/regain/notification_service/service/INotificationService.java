package com.regain.notification_service.service;


import com.regain.notification_service.model.MessageActiveResponse;
import com.regain.notification_service.model.MessageBirthDay;
import com.regain.notification_service.model.MessageSendActiveUser;

public interface INotificationService {
    void sendEmailActive(MessageSendActiveUser messageSendActiveUser);
    void sendEmailActiveResponse(MessageActiveResponse messageActiveResponse);
    void sendEmailHappyBirthDay(MessageBirthDay messageBirthDay);
}
