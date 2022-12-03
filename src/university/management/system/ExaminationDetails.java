
package university.management.system;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ExaminationDetails implements ActionListener{
    
    public static void main(String[] args) {
        new ExaminationDetails();
    }
    
    JFrame marksDetailsBgFrame,marksDetailsFrame;
    JButton searchButton,cancelButton;
    JLabel title,enterRollNoLabel;
    JTextField enterRollTextField;
    public ExaminationDetails()  {
    /*============Adding Background image first=================*/
                    marksDetailsBgFrame = new JFrame();
                    marksDetailsBgFrame.setSize(1920,1080);
                    marksDetailsBgFrame.setLocation(0,0);
                    marksDetailsBgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    marksDetailsBgFrame.setLayout(null);

                    ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/Background2.png"));
                    Image img2 = img.getImage().getScaledInstance(1920, 1080,Image.SCALE_SMOOTH);
                    ImageIcon img3 = new ImageIcon(img2);

                    JLabel addBackgroundImage = new JLabel(img3);
                    addBackgroundImage.setBounds(0,0,1920,1080);
                    marksDetailsBgFrame.add(addBackgroundImage);
                    marksDetailsBgFrame.setUndecorated(true);
                    marksDetailsBgFrame.setResizable(false);
                    marksDetailsBgFrame.setVisible(true);
        
                    
                    
        marksDetailsFrame = new JFrame();
        marksDetailsFrame.setSize(1100,600);
        marksDetailsFrame.setLocation(400,200);
        marksDetailsFrame.getContentPane().setBackground(Color.WHITE);
        marksDetailsFrame.setLayout(null);
        marksDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //=========================Title of the form====================================

        title = new JLabel("Check Result");
        title.setBounds(350,10,500,50);
        title.setFont(new Font("Times New Roman",Font.BOLD,35));
        marksDetailsFrame.add(title);
        
        /*=========================Roll no. lable=============================*/
        enterRollNoLabel = new JLabel("Enter your rollno");
        enterRollNoLabel.setBounds(50,100,250,30);
        enterRollNoLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        marksDetailsFrame.add(enterRollNoLabel);
        
        /*========================Roll no. TextField==========================*/        
        enterRollTextField = new JTextField();
        enterRollTextField.setBounds(250,100,200,30);
        enterRollTextField.setFont(new Font("Times New Roman",Font.BOLD,25));
        marksDetailsFrame.add(enterRollTextField);
        
        
        /*======================Search Button and Image Icon====================================*/
        ImageIcon searchIcon = new ImageIcon(ClassLoader.getSystemResource("icons/searchIcon.png"));
        Image searchImg = searchIcon.getImage().getScaledInstance(38, 33,Image.SCALE_SMOOTH);
        ImageIcon searchFinalImageIcon = new ImageIcon(searchImg);

        searchButton = new JButton(searchFinalImageIcon);
        searchButton.setBounds(460,98,38,33);
        searchButton.setBackground(Color.WHITE);

         // ADDING CURSOR SYMBOL 
        searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

         //SETTING BORDER TRANSPARENT
        searchButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        searchButton.addActionListener(this);
        marksDetailsFrame.add(searchButton);

            
        
        
        
        
        
        
        /*=========================Cancel Button Image Icon====================*/
        ImageIcon cancelIcon = new ImageIcon(ClassLoader.getSystemResource("icons/CancelButtonImage.png"));
        Image cancel = cancelIcon.getImage().getScaledInstance(210, 85, Image.SCALE_SMOOTH);
        ImageIcon cancelFinalImageIcon = new ImageIcon(cancel);

        cancelButton=  new JButton(cancelFinalImageIcon);
        cancelButton.setBounds(100,500,185,60);
        cancelButton.setBackground(Color.WHITE);
        
        // ADDING CURSOR SYMBOL 
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //SETTING BORDER TRANSPARENT
        cancelButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        cancelButton.addActionListener(this);
        marksDetailsFrame.add(cancelButton);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        marksDetailsFrame.setUndecorated(true);
        marksDetailsFrame.setShape(new RoundRectangle2D.Double(0, 0, 1100, 600, 30, 30)); //This will make the edges rounded
        marksDetailsFrame.setResizable(false);
        
        marksDetailsFrame.setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
     if(ae.getSource() == cancelButton){
         marksDetailsFrame.dispose();
         marksDetailsBgFrame.dispose();
     }   
    }
    
    
}
