package main.java.message.UseCase;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * This class is a UseCase class, which is used for sending email via the application.
 * The content of the email is the content typed by the User in the Chat panel.
 * @author GEN LI (Reagan)
 */

public class SendMailUseCase_Admin {

//    public static String senderAccount = "bugproducer207@gmail.com";
//    public static String senderPassword = "Bugproducer123";

    public static String SMTPHost = "smtp.gmail.com";


    /**
     * This method is used for creating an email with sender and receiver.
     * @param session_R Session object for this email, which represents a mail session.
     * @param senderMail The email address of the sender.
     * @param receiverMail The email address of the receiver.
     * @param user_input The user's input, which is used as the content of th email.
     * @return message_R an email with needed information.
     */

    public static MimeMessage createMail(Session session_R, String senderMail, String receiverMail, String user_input) {
        MimeMessage message_R = new MimeMessage(session_R);
        try{
        message_R.setFrom(new InternetAddress(senderMail, "Bugproducer", "UTF-8"));
        message_R.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiverMail, "Customer", "UTF-8"));
        message_R.setSubject("Message from Admin", "UTF-8");
        message_R.setContent(user_input, "text/html;charset=UTF-8");
        message_R.setSentDate(new Date());
        message_R.saveChanges();}
        catch(Exception ignored){}
        return message_R;
    }


    /**
     * This method is used for sending an email to receiverAccount from senderAccount.
     * @param user_input The user's input, which is used as the content of th email.
     * @param senderAccount The email address of the sender.
     * @param receiverAccount The email address of the receiver.
     */

    public static void send_mail(String user_input, String senderAccount, String receiverAccount)  {
        try{Properties props = new Properties();
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
        transport.connect(senderAccount, "Bugproducer123");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();}
        catch(Exception ignored){}
    }
}
