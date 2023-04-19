package mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;;
import java.nio.file.*;
import java.util.*;

public class EmailUtility {
    private static final Properties props = new Properties();
    static {
        //Setting Properties of SMTP server
        props.put("mail.smtp.host","smtp.gmail.com"); //mail.smtp.yahoo.com for yahoo server
        props.put("mail.smtp.port",587);
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
    }
    public static void sendMail(EmailMessage emailmsg){

        try {
            Path filename = Path.of("/password.txt");//Add the absolute path reference of password.txt
            String pass = Files.readString(filename);
            String sender_email = "your_email@gmail.com";//---Add your email here---
            String sender_email_pass = pass;//Add your password in password.txt
            //Creating a session to login using the properties
            Session session = Session.getDefaultInstance(props,new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(sender_email,sender_email_pass);
                }
            });
            session.setDebug(true);

            //create Message
            Message msg = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress(sender_email);
            msg.setFrom(addressFrom);
            //Set To addresses
            String[] emailIds = new String[0];
            if(emailmsg.getTo()!=null){
                emailIds = emailmsg.getTo().split(",");
            }
            InternetAddress[] addressesTo = new InternetAddress[emailIds.length];
            for(int i=0;i<emailIds.length;i++){
                addressesTo[i]= new InternetAddress(emailIds[i]);
            }

            if(addressesTo.length>0){
                msg.setRecipients(Message.RecipientType.TO,addressesTo);
            }

            msg.setSubject(emailmsg.getSubject());

            switch (emailmsg.getMessageType()){
                case EmailMessage.HTML_MSG:
                    msg.setContent(emailmsg.getMessage(),"text/html");
                    break;
                case EmailMessage.TEXT_MSG:
                    msg.setContent(emailmsg.getMessage(),"text/plain");
                    break;
            }
            Transport.send(msg);

        }catch(Exception ae){System.out.println(ae);}
    }
}
