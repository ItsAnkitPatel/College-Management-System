package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;

public class Login  implements ActionListener,Runnable {
    
    static JFrame loginFrame;
    Thread t;
    JFrame popupFailureImageFrame;
    JPasswordField passwordJTextField; 
    JTextField userJTextField;
    
        
    JButton loginButton;
    JButton exitButton ;
   
   
    public Login(){
        loginFrame = new JFrame();
        loginFrame.getContentPane().setBackground(Color.WHITE);
        loginFrame.setLayout(null);    
        loginFrame.setSize(1000,690);
        loginFrame.setLocation(450,200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setUndecorated(true);
        loginFrame.setShape(new RoundRectangle2D.Double(0, 0, 1000,660, 30, 30)); //This will make the edges rounded
        loginFrame.setResizable(false);
       
        
/*============================================== ImageIcon ===========================================================*/
        ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginPage.png"));
        Image i2 = i1.getImage().getScaledInstance(1000,667, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel finalImageJLabel = new JLabel(i3);
        finalImageJLabel.setBounds(0, 0, 1000, 667);
        loginFrame.add(finalImageJLabel);        
        
        
        
        
/*============================================= UserName =========================================================*/

        userJTextField = new JTextField();
        
        userJTextField.setBackground(new Color(234,232,255,255));        
        userJTextField.setBorder(null);
        userJTextField.setToolTipText("Enter your username");// When user hover over the textfield the given text will message will show
        userJTextField.setBounds(695,288,150,20);
        
        loginFrame.add(userJTextField);
        
        
        
/*============================================= Password ==========================================================*/

        passwordJTextField = new JPasswordField();
        
        passwordJTextField.setBackground(new Color(234,232,255,255));
        passwordJTextField.setBorder(null);
        passwordJTextField.setToolTipText("Enter your password");// When user hover over the textfield the given text will message will show
        passwordJTextField.setBounds(695,328,150,20);
   
        loginFrame.add(passwordJTextField);
        
        
        
/*==============================================Login Button==========================================================*/        
        
        loginButton=  new JButton();
        loginButton.setBounds(712,400,80,20);
        loginButton.setBackground(new Color(0,0,0,0));
        
        
        // ADDING CURSOR SYMBOL 
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //SETTING BORDER TRANSPARENT
        loginButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        loginButton.addActionListener(this);
        
        finalImageJLabel.add(loginButton);
        
        
/*========================================ExitImage + Text + Button=====================================================*/
        
        ImageIcon exitImage= new ImageIcon(ClassLoader.getSystemResource("icons/ExitImage.png"));
        Image exit = exitImage.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon exit2 = new ImageIcon(exit);

                
        //=========Exit Button============ 
        exitButton = new JButton(exit2);
        exitButton.setBounds(900, 575, 60, 50);
        exitButton.setBackground(new Color(0,0,0,0));
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //SETTING BORDER TRANSPARENT
        exitButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        exitButton.addActionListener(this);
        finalImageJLabel.add(exitButton);
        
        
        //=========Exit Text======================
        JLabel exitText = new JLabel("EXIT");
        exitText.setBounds(940,620,100,30);
        
        finalImageJLabel.add(exitText);


/*==============================================THE END===========================================================*/

        loginFrame.setVisible(true);
        
    }
/*When the given credentials are wrong then we will execute the below method */
    void popUpFailureImage(){
               
        t = new Thread(this);
        popupFailureImageFrame = new JFrame();
        popupFailureImageFrame.setUndecorated(true); //removes the surrounding border

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/FailureImage.jpg")); //imports the image
        Image workDoneImage = image.getImage().getScaledInstance(850, 600,Image.SCALE_SMOOTH);
        ImageIcon finalworkDoneImageIcon = new ImageIcon(workDoneImage);
        JLabel lbl = new JLabel(finalworkDoneImageIcon); //puts the image into a jlabel

        popupFailureImageFrame.getContentPane().add(lbl); //puts label inside the jframe

        
        popupFailureImageFrame.setLocation(500,200);
        popupFailureImageFrame.setSize(850,600);
        popupFailureImageFrame.setShape(new RoundRectangle2D.Double(0, 0, 850, 600, 30, 30)); //This will make the edges rounded
        popupFailureImageFrame.setVisible(true); //makes the jframe visible
      
        t.start();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
        

        //Getting username and password for validation 
         String username = userJTextField.getText();
         String password = String.valueOf(passwordJTextField.getPassword());
         
         
         //Generating query
         String query = "select * from login where username='"+username+"' and password='"+password+"';";
         
         
         
         /*Step 4.==========Executing the MySQL Queries ======Part of "Creating JDBC" steps=============*/  
            
            try {
                
                
                //creating connection first
                
                Conn c= new Conn(); /*This will create a connection because 
                                      we already have a driver class in Conn constructor*/
                
                ResultSet rs =c.s.executeQuery(query);
                
                if(rs.next()){
                    
                    loginFrame.dispose();
                    new Dashboard();
                    
                    
                }else{//If validation is false then we will show popup of failure with the help of image      
                   loginFrame.setVisible(false);
                   popUpFailureImage();
                }
                
                //c.s.close(); //This is Step 5 of JDBC : Closing the connection .This is optional but a good practice
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getSource() == exitButton){
            exitButton.setVisible(false);
            exitButton.setVisible(true);
            loginFrame.dispose(); //Alternative of System.exit(0);          
        }
        
    }   

    @Override
    public void run() {
        
        try {
            
            Thread.sleep(1000);
            popupFailureImageFrame.dispose();
            loginFrame.dispose();
            
            new Login();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
    }

   
}
