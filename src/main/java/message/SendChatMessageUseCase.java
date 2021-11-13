package main.java.message;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * This class is a UseCase class, which is used for sending email via the application.
 * The content of the email is the content typed by the User in the Chat panel.
 */

public class SendChatMessageUseCase {

//    public static String senderAccount = "bugproducer207@gmail.com";
//    public static String senderPassword = "Bugproducer123";

    public static String SMTPHost = "smtp.gmail.com";

    /**
     * This method is used for creating an email with sender and receiver.
     * It returns an email with needed information. It requires the session,sender email address, receiver email address
     * and the content of the email.
     */

    public static MimeMessage createMail(Session session_R, String senderMail, String receiverMail, String user_input) throws Exception {
        MimeMessage message_R = new MimeMessage(session_R);
        message_R.setFrom(new InternetAddress(senderMail, "bugproducer", "UTF-8"));
        message_R.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiverMail, "reagan.li8589", "UTF-8"));
        message_R.setSubject("Chat Message", "UTF-8");
        message_R.setContent(user_input, "text/html;charset=UTF-8");
        message_R.setSentDate(new Date());
        message_R.saveChanges();
        return message_R;
    }

    /**
     * This method is used for sending an email to receiverAccount from senderAccount.
     * Specifically, the method requires content of the email, senderAccount, receiverAccount and senderPassword as parameters.
     * This method returns nothing.
     */

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

        MimeMessage message = createMail(session, senderAccount, receiverAccount, user_input);

        Transport transport = session.getTransport();
        transport.connect(senderAccount, senderPassword);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
