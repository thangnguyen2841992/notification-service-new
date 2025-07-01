package com.regain.notification_service.service;

import com.regain.notification_service.model.MessageSendActiveUser;
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
}
