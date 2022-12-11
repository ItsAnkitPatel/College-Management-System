package college.management.system;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About implements ActionListener{
    JFrame aboutFrame;
    JLabel title;
    JButton twitterButton,linkedinButton,githubButton,exitButton;
    public About() {
        
    
            
                    
        aboutFrame = new JFrame();
        aboutFrame.setSize(1100,1000);
        aboutFrame.setLocation(450,50);
        aboutFrame.getContentPane().setBackground(Color.WHITE);
        aboutFrame.setLayout(null);
        aboutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aboutFrame.setUndecorated(true);
        aboutFrame.setShape(new RoundRectangle2D.Double(0, 0, 1100, 1000, 30, 30)); //This will make the edges rounded
        aboutFrame.setResizable(false);
        
/*============================================== Title of the form =======================================================*/

        title = new JLabel("About Project ");
        title.setBounds(400,5,500,50);
        title.setFont(new Font("Times New Roman",Font.BOLD,45));
        aboutFrame.add(title);
                 
    
        
/*=================================================Image Icon============================================================*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/AboutImage.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 550,Image.SCALE_SMOOTH);
        ImageIcon finalImageIcon = new ImageIcon(i2);
    

        JLabel addImage = new JLabel(finalImageIcon);
        addImage.setBounds(120,70,800,550);
        aboutFrame.add(addImage);
        
        JLabel aboutMeTextLabel = new JLabel();
        aboutMeTextLabel.setBounds(200,620,600,240);
        aboutMeTextLabel.setFont(new Font("FreeSerif",Font.PLAIN,20));
        aboutMeTextLabel.setText(
        "<html>"+
                    "Hello there👋, I hope you are doing great. I'm Ankit Patel a JAVA developer.<br><br>"+
                    "This project consist multiple functonalities like adding student & teacher data, "+
                    "storing & showing student marks, adding or updating the student & teacher data.<br><br>"+


                    "This project purely based on java language, this project uses javaswing for showing frame to the user."+
                    "We used mySQL for storing the data in a local database ."
                +
        "</html>"
        );
        
        aboutFrame.add(aboutMeTextLabel);

/*=================================================Socila links====================================================*/
    /*We will add social icons in button and when the user click those 
      buttons it will get redirected to our social media accouts*/
    
        /*First we will add github link*/
            
            /*===========GithubIcon===========================*/
            ImageIcon gitIcon = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icons/githubicon.png"))
                                              .getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
    
            githubButton = new JButton(gitIcon);
            githubButton.setBounds(390,870,50,50);
            githubButton.setBackground(Color.WHITE);
            //Setting border transparent
            githubButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            githubButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            githubButton.addActionListener(this);
            aboutFrame.add(githubButton);
            
            
            
            /*===========Twitter Icon===========================*/

            ImageIcon twitterIcon = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icons/TwitterIcon.jpg"))
                                              .getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
    
            
            twitterButton = new JButton(twitterIcon);
            twitterButton.setBounds(460,870,60,60);
            twitterButton.setBackground(Color.WHITE);
            //Setting border transparent
            twitterButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            twitterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            twitterButton.addActionListener(this);
            aboutFrame.add(twitterButton);
            
            
            /*===========LinkedIn Icon===========================*/

            ImageIcon linkedinIcon = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icons/LinkedinIcon.jpg"))
                                              .getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
    
            
            linkedinButton = new JButton(linkedinIcon);
            linkedinButton.setBounds(535,870,60,60);
            linkedinButton.setBackground(Color.WHITE);
            //Setting border transparent
            linkedinButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            linkedinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            linkedinButton.addActionListener(this);
            aboutFrame.add(linkedinButton);
            
            
/*=================================================Exit Button ====================================================*/
        exitButton = new JButton("⬅  Exit");
        exitButton.setBounds(20,950,100,30);
        exitButton.setBackground(Color.WHITE);
        exitButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        exitButton.setFont(new Font("FreeSerif",Font.PLAIN,20));
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.addActionListener(this);
        aboutFrame.add(exitButton);
        
/*================================================= THE END ===========================================================*/                 
    aboutFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==githubButton){
                    try {
                        String url = "https://github.com/ItsAnkitPatel"; 
                        Desktop desktop = java.awt.Desktop.getDesktop();
                        URI URL = new URI(url);
                        desktop.browse(URL);
                    } catch (IOException | URISyntaxException ex) {
                        System.out.println("Exception"+ex);
                    }
        }
        
        else if(e.getSource() == twitterButton){
                    try {        
                        String url = "https://twitter.com/Its_AKPatel"; 
                        Desktop desktop = java.awt.Desktop.getDesktop();
                        URI URL = new URI(url);
                        desktop.browse(URL);
                    } catch (IOException | URISyntaxException ex) {
                        System.out.println("Exception"+ex);
                    }
        }
        
        else if(e.getSource() == linkedinButton){
                    try {  
                           String url = "https://www.linkedin.com/in/itsakpatel/";
                           Desktop desktop = java.awt.Desktop.getDesktop();
                           URI URL = new URI(url);
                           desktop.browse(URL);
                       } catch (IOException | URISyntaxException ex) {
                           System.out.println("Exception"+ex);
                       }
        }else if(e.getSource() == exitButton){
            aboutFrame.dispose();
            Dashboard.dashboardFrame.setVisible(true);
        }
    }
}
