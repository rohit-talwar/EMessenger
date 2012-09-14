import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class Recieve implements Runnable{
    private String uname;
    private String pswrd;
    static public int messnum;
    
    
    public Recieve(String user,String pass){
        this.uname = user;
        this.pswrd = pass;
    }
    @Override
    public void run(){
        try {
            getchat(uname,pswrd);
        } catch (Exception ex) {
            Logger.getLogger(Recieve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getchat (final String username,final String password) throws Exception {
        System.getProperties().put("http.proxyHost", "proxy.iiit.ac.in");
        System.getProperties().put("http.proxyPort", "8080");
        String host = "pop.gmail.com";
        
        // Create empty properties
        Properties props = new Properties();
        props.put("mail.pop3s.socketFactory.port", "995");
        props.put("mail.pop3s.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.pop3s.host", "pop.gmail.com");
        props.put("mail.pop3s.port", "995");
        props.put("mail.pop3.ssl.enable", true);
        
        final Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }});
        //Session session = Session.getDefaultInstance(props,null);
        
        
        Store store = session.getStore("pop3");
        store.connect(host, username, password);
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);
        Message message[] = folder.getMessages();
        
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(System.in));
        //Date today = new Date();
        String incoming,senderadd;
        // Get directory
        for (int i=0, n=message.length; i<n; i++) {
            
            // Display from field and subject
            //System.out.println(i + ": " + message[i].getFrom()[0]
            //      + "\t" + message[i].getSubject());
            Date mdate = message[i].getReceivedDate();
            incoming = message[i].getSubject();
            if(incoming.startsWith("Talwar IM",0) && messnum<message[i].getMessageNumber()){
                //System.out.println("inside the loop");
        //        if(today.getYear()==mdate.getYear() && today.getMonth()==mdate.getMonth() && today.getDate()==mdate.getDate()){
                    senderadd = message[i].getFrom()[0].toString();
                    System.out.print(senderadd.subSequence(14, senderadd.length()));
                    System.out.println(incoming.subSequence(9, incoming.length()));
                    messnum = message[i].getMessageNumber();
                    System.out.println("the email number so far == "+messnum);
          //      }
            }
            //if(messnum==message[i].getMessageNumber()){
            //    Thread.sleep(2000);
            //}
            //System.out.println("Do you want to read message? [YES to read/QUIT to end]");
            //String line = reader.readLine();
        }
        folder.close(false);
        store.close();
    }
}