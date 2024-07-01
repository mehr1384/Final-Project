package org.example.final_project;



import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    public static void sendEmail(String recipient, String code) {
        final String username = "javaa1384@gmail.com";
        final String password = "javajava";

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
            message.setFrom(new InternetAddress("javaa1384@gmail.com"));
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


