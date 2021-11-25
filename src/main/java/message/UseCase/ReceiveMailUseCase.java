package main.java.message.UseCase;

import com.sun.mail.pop3.POP3SSLStore;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.ArrayList;
import java.util.Properties;

public class ReceiveMailUseCase {

    public static Message[] prepare() throws Exception {
        //准备登陆信息
        Properties props = new Properties();
        String host = "pop.gmail.com";
        int port = 995;
        String username = "bugproducer207@gmail.com";
        String password = "Bugproducer123";



        props.setProperty("mail.store.protocol", "pop3");
        props.setProperty("mail.pop3.host", host);//pop3 主机名
        props.setProperty("mail.pop3.port", String.valueOf(port));//
        //启动SSL
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", port);

        //链接到Store;
        URLName url = new URLName("pop3",host, port,"",username,password);
        Session session = Session.getInstance(props,null);
        session.setDebug(false);
        Store store = new POP3SSLStore(session,url);
        store.connect();

        //获取收件箱
        Folder folder = store.getFolder("INBOX");

        //以读写方式打开
        folder.open(Folder.READ_WRITE);
        //打印邮件总数/新邮件数量/未读数量/已删除数量
        System.out.println("Total message： " + folder.getMessageCount());
//        System.out.println("New message： " + folder.getNewMessageCount());
//        System.out.println("Unread message： " + folder.getUnreadMessageCount());
//        System.out.println("Deleted message： " + folder.getDeletedMessageCount());
        //获取每一封邮件
//        Message[] messages = folder.getMessages();
//        for(Message message:messages){
//            //打印每一封邮件
//            printMessage((MimeMessage)message);
//        }
        return folder.getMessages();//0位置是最早的邮件，即最新邮件为-1。
    }



    static void printMessage(MimeMessage msg) throws Exception {
        //邮件主题
        System.out.println("Subject: " + MimeUtility.decodeText(msg.getSubject()));
        //发件人
        Address[] froms = msg.getFrom();
        //打印地址
        InternetAddress address = (InternetAddress) froms[0];
        String personal = address.getPersonal();
        String from = personal == null ? address.getAddress() : (MimeUtility.decodeText(personal) + " <" + address.getAddress() + " >");
        System.out.println("From: " + from);
        //继续打印收件人
        System.out.println("Body: " + getBody(msg));

    }

    static String getBody(Part part) throws Exception {

        if(part.isMimeType("text/*")) {
            //Part 是文本
            return part.getContent().toString();
        }
        if(part.isMimeType("multipart/*")){
            //Part 是一个Multipart对象
            Multipart multipart = (Multipart) part.getContent();
            //循环解析每个子Part
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

//    public void disconnect(){
//        folder.close(true); // 传入true表示删除操作会同步到服务器上（即删除服务器收件箱的邮件）
//        store.close();
//    }

    public static void main(String[] args) throws Exception {
        Message[] a = ReceiveMailUseCase.prepare();
        printMessage((MimeMessage)a[a.length - 1]);



    }
}

