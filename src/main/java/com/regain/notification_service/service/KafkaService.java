package com.regain.notification_service.service;

import com.regain.notification_service.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    private INotificationService notificationService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @KafkaListener(id = "sendEmailActiveGroup", topics = "send-email-active")
    public void receiveEmailActive(MessageSendActiveUser messageSendActiveUser) {
        logger.info("Received email: {}", messageSendActiveUser.getToEmail());
        this.notificationService.sendEmailActive(messageSendActiveUser);
    }

    @KafkaListener(id = "sendEmailActiveResponseGroup", topics = "send-email-active-response")
    public void receiveEmailActiveResponse(MessageActiveResponse messageActiveResponse) {
        logger.info("Received email: {}", messageActiveResponse.getToUserEmail());
        this.notificationService.sendEmailActiveResponse(messageActiveResponse);
    }

    @KafkaListener(id = "sendEmailBirthDayResponseGroup", topics = "send-email-birthday-response")
    public void receiveEmailBirthDay(MessageBirthDay messageBirthDay) {
        logger.info("Received email: {}", messageBirthDay.getEmail());
        this.notificationService.sendEmailHappyBirthDay(messageBirthDay);
    }

    @KafkaListener(id = "sendEmailOrderGroup", topics = "send-email-order")
    public void receiveEmailOrder(MessageOrder messageOrder) {
        logger.info("Received email: {}", messageOrder.getToEmail());
        this.notificationService.sendEmailOrder(messageOrder);
    }

    @KafkaListener(id = "sendEmailOrderMessageGroup", topics = "send-email-order-message")
    public void receiveEmailOrderProcess(MessageOrderResponse messageOrder) {
        logger.info("Received email: {}", messageOrder.getToEmail());
        this.notificationService.sendEmailProcessOrder(messageOrder);
    }
}
