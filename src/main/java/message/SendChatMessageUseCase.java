package main.java.message;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendChatMessageUseCase {

//    public static String senderAccount = "bugproducer207@gmail.com";
//    public static String senderPassword = "Bugproducer123";

    public static String SMTPHost = "smtp.gmail.com";

//    public static String receiverAccount = "reagan.li@icloud.com";

    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String user_input) throws Exception {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sendMail, "bugproducer", "UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "reagan.li8589", "UTF-8"));
        message.setSubject("Chat Message", "UTF-8");
        message.setContent(user_input, "text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }

    public static void sendChatMessage_mail(String user_input, String senderAccount, String receiverAccount, String senderPassword) throws Exception {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", SMTPHost);
        props.setProperty("mail.smtp.auth", "true");


        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);

        Session session = Session.getInstance(props);
        session.setDebug(true);

        MimeMessage message = createMimeMessage(session, senderAccount, receiverAccount, user_input);

        Transport transport = session.getTransport();
        transport.connect(senderAccount, senderPassword);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

}
