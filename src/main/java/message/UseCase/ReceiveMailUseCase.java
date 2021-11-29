package main.java.message.UseCase;

import com.sun.mail.pop3.POP3SSLStore;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.Properties;

/**
 * This is a UseCase that can pull the mails from the email box.
 * @author Gen LI.
 */

public class ReceiveMailUseCase {

    /**
     * This is a method that used to prepare for the receiving emails. Setting the basic
     * information required for receiving email
     * @return a list of Message objects. The list contains all the mail in it.
     * The last one in the list is the latest email
     */

    public static Message[] prepare(String username, String password) throws Exception {

        Properties props = new Properties();
        String host = "pop.gmail.com";
        int port = 995;



        props.setProperty("mail.store.protocol", "pop3");
        props.setProperty("mail.pop3.host", host);
        props.setProperty("mail.pop3.port", String.valueOf(port));//

        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", port);


        URLName url = new URLName("pop3",host, port,"",username,password);
        Session session = Session.getInstance(props,null);
        session.setDebug(false);
        Store store = new POP3SSLStore(session,url);
        store.connect();


        Folder folder = store.getFolder("INBOX");


        folder.open(Folder.READ_WRITE);

        System.out.println("Total message： " + folder.getMessageCount());

        return folder.getMessages();
    }


    /**
     * This is a method that print out the content, subject, sender, receiver of the email.
     * @param message_ This is a parameter that represents the String type message generated
     *                 according to the mails in the mail inbox
     */

    static void printMessage(MimeMessage message_) throws Exception {

        System.out.println("Subject: " + MimeUtility.decodeText(message_.getSubject()));

        Address[] froms = message_.getFrom();

        InternetAddress address = (InternetAddress) froms[0];
        String personal = address.getPersonal();
        String from = personal == null ? address.getAddress() : (MimeUtility.decodeText(personal) + " <" + address.getAddress() + " >");
        System.out.println("From: " + from);

        System.out.println("Body: " + getBody(message_));

    }

    /**
     * This is a method that get the content of the body of the mails in the email inbox.
     * @param part This is a parameter that represents the String type message generated
     *             according to the mails in the mail inbox
     * @return String. this method return a String that represents the content of the email.
     */

    static String getBody(Part part) throws Exception {

        if(part.isMimeType("text/*")) {

            return part.getContent().toString();
        }
        if(part.isMimeType("multipart/*")){

            Multipart multipart = (Multipart) part.getContent();

            for(int i = 0;i<multipart.getCount();i++){
                BodyPart bodyPart = multipart.getBodyPart(i);
                String body = getBody(bodyPart);
                if(!body.isEmpty()){
                    return body;
                }
            }
        }
        return "";
    }

    /**
     * This method is used for the action of pulling emails from the mail inbox.
     * @param username this is the user account that the programmer is trying to pull emails from.
     * @param password this is the user password that the programmer is trying to pull emails from.
     */

    public static void receive_email(String username, String password) throws Exception {
        Message[] a = ReceiveMailUseCase.prepare(username, password);
        printMessage((MimeMessage)a[a.length - 1]);
    }


}

