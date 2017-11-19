/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.*;

/**
 *
 * @author arkane
 */
public class SendEmailAttachment {
//String from, String to, String host, String filepath
    public static void ConstructEmail(String from, String to, String filepath) throws IOException{
        //    From database pull user id.
        //    Store user id and email address in Map structure
        //    Check user ids with those from database
        
//        Map<String, String> useremails = new HashMap<>();
        // useremails.put("user_id", "user_email");

//        from = "akane.simpson@gmail.com";
//        to = "akalx44@gmail.com";
        String host = "localhost";

        final String username = "";
        final String password = "";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthenticator() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Testing");

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
//            filepath = "";
            DataSource source = new FileDataSource(filepath);

            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filepath);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println();

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
//    public static void main(String [] args) throws IOException{
//        SendEmailAttachment test = new SendEmailAttachment();
//                test.ConstructEmail();
//    }
}