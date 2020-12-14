package com.aleks._8;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class Sender {
    public static void send() throws IOException, MessagingException {
        Properties properties=new Properties();
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        Session mailSession= Session.getDefaultInstance(properties);
        MimeMessage message=new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("vitvor01@gmail.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress("avitvor@gmail.com"));
        message.setSubject("Start of app");
        message.setText("Somebody start your app");

        Transport tr=mailSession.getTransport();
        tr.connect("vitvor01@gmail.com", "Aleks7907!");

        tr.sendMessage(message, message.getAllRecipients());
        tr.close();
    }
}