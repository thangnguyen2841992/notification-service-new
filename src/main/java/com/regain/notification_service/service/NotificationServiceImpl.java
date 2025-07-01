package com.regain.notification_service.service;

import com.regain.notification_service.model.MessageActiveResponse;
import com.regain.notification_service.model.MessageSendActiveUser;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements INotificationService{

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String fromEmail;

    @Override
    @Async
    public void sendEmailActive(MessageSendActiveUser messageSendActiveUser) {
        String subject = "Kích hoạt tài khoản của bạn tại Order Restaurant";
        String text = "<br/> Xin chào" + messageSendActiveUser.getToName() + "<br/> Click vào đường link để kích hoạt tài khoản: ";
        String url = "http://localhost:3000/active/" + messageSendActiveUser.getToUserId() + "/" + messageSendActiveUser.getActiveCode();
        text += ("<br/> <a href=" + url + ">" + url + "</a>");
        sendMailActiveAccount(messageSendActiveUser.getToEmail(), subject, text);
    }

    @Override
    @Async
    public void sendEmailActiveResponse(MessageActiveResponse messageActiveResponse) {
        String subject = "Xin chào " +  messageActiveResponse.getToUserFullName();
        String text = "Bạn đã kích hoạt thành công tài khoản ở Order Restaurant. Bạn có thể sử dụng dịch vụ của chúng tôi." + "<br>" + "Cám ơn bạn!";
        sendMailActiveAccount(messageActiveResponse.getToUserEmail(), subject, text);
    }

    private void sendMailActiveAccount(String toEmail, String subject, String text) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(fromEmail);
            helper.setTo(toEmail);
            helper.setText(text, true);
            helper.setSubject(subject);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        this.javaMailSender.send(message);
    }
}
