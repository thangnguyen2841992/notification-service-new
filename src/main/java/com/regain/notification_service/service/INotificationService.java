package com.regain.notification_service.service;


import com.regain.notification_service.model.*;

public interface INotificationService {
    void sendEmailActive(MessageSendActiveUser messageSendActiveUser);
    void sendEmailActiveResponse(MessageActiveResponse messageActiveResponse);
    void sendEmailHappyBirthDay(MessageBirthDay messageBirthDay);
    void sendEmailOrder(MessageOrder messageOrder);
    void sendEmailProcessOrder(MessageOrderResponse messageOrder);
}
