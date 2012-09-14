
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rohit
 */
public class Input {
    
    
    
    public static void main(String args[]) throws IOException{
        BufferedReader reader = new BufferedReader ( new InputStreamReader(System.in));
        System.out.println("enter your details\nusername");
        String username = reader.readLine();
        System.out.println(username);
        System.out.println("password");
        String password = reader.readLine();
        System.out.println(password);
        System.out.println("Enter friend's username\n");
        String frnd = reader.readLine();
        System.out.println(frnd);
        thre reciever = new thre(username,password);
        Runnable runnable1 = reciever;
        // Create the thread supplying it with the runnable object
        Thread thread1 = new Thread(runnable1);
        // Start the thread
        thread1.start();
        while(true){
            System.out.println("Enter text to send OR Enter CHANGE to change the friend's id OR Enter QUIT to exit \n");
            String chat = reader.readLine();
            if("QUIT".equals(chat)){
                thread1.start();
                //reciever.quitrecieving();
                break;
            }
            if("CHANGE".equals(chat)){
                System.out.println("Enter friend's username");
                frnd = reader.readLine();
                continue;
            }
            
            Runnable runnable = new SendMailTLS(username,password,frnd,chat);
            // Create the thread supplying it with the runnable object
            Thread thread = new Thread(runnable);
            // Start the thread
            thread.start();
        }
    }
}
