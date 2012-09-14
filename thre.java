
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
public class thre implements Runnable{
    private String uname,pswd;
    private boolean timetoquit;
    public thre(String username,String password){
        uname = username;
        pswd = password;
        timetoquit = false;
    }
    @Override
    public void run(){
        while(!timetoquit){
            Runnable runnable = new Recieve(uname,pswd);
            Thread thread = new Thread(runnable);
            try {
               Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
            }
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void quitrecieving(){
        timetoquit = true;
    }
}
