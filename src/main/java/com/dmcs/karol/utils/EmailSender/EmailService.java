package com.dmcs.karol.utils.EmailSender;

public interface EmailService {

    void sendEmail(String to, String subject, String content);
}
