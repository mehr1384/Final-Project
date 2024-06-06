package org.example.final_project;



import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    public static void sendEmail(String recipient, String code) {
        final String username = "faeze.saghi13484@gmail.com";
        final String password = "faeze1384";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("faeze.saghi13484@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipient));
            message.setSubject("Your Verification Code");
            message.setText("Your verification code is: " + code);

            Transport.send(message);

            System.out.println("Email sent!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateRandomCode() {
        int code = (int)(Math.random() * 90000) + 10000;
        return String.valueOf(code);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        String code = generateRandomCode();
        sendEmail(email, code);
    }
}


//
//import java.util.Properties;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class EmailSender {
//    public static void sendEmail(String to, String code, String username, String password) {
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.mail.yahoo.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//            message.setSubject("Password Reset Code");
//            message.setText("Your password reset code is: " + code);
//
//            Transport.send(message);
//        } catch (MessagingException e) {
//
//            throw new RuntimeException(e);
//        }
//    }
//}
//import java.util.Properties;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class EmailSender {
//    public static void sendEmail(String to, String code) {
//        final String username = "f@yahoo.com";
//        final String password = "";
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.mail.yahoo.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("your_email@yahoo.com"));
//            message.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse(to));
//            message.setSubject("Password Reset Code");
//            message.setText("Your password reset code is: " + code);
//
//            Transport.send(message);
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
