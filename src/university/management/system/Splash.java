package university.management.system;

import java.awt.*;
import javax.swing.*;

public class Splash  implements Runnable{
    Thread t;
    JFrame  frame ;
    
    public Splash() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("icons/CollegeWelcome.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1300, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        
        frame.add(image);
        
        
        t= new Thread(this);
        t.start();
        
        frame.setVisible(true);
        
        int x =1;
        /*This loop will make the animation of welcome college image*/
        for(int i =2; i <= 600; i+=4,x +=1){
        frame.setLocation(750-((i+x)/2),400-(i/2));
        frame.setSize(i+4*x,i+(x/2)+200);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }        
        }
        
    
        
    }
    
    @Override
    public void run() {
        try {
            
           Thread.sleep(3000);
           frame.setResizable(false);
           frame.dispose();
            new Login();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        new Splash();

    }
}