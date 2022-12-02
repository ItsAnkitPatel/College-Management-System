
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
public class EnterMarks implements ActionListener,Runnable {
    JFrame enterMarksFrame, enterMarksbgFrame;
    JLabel title,rollNoLabel,semesterLabel;
    Choice rollNoChoice;
    JComboBox semesterComboBox;
    JButton cancelButton,submitButton;
    JLabel subjectCodeLabel,subjectLable,marksLable;
    JTextField sub1Code,sub2Code,sub3Code,sub4Code,sub5Code;
    JTextField subject1TF,subject2TF,subject3TF,subject4TF,subject5TF;
    JTextField subject1marksTF,subject2marksTF,subject3marksTF,subject4marksTF,subject5marksTF;
    Thread t;
    JFrame popupFailureImageFrame;
    public EnterMarks() {
        
        /*============Adding Background image first=================*/
                    enterMarksbgFrame = new JFrame();
                    enterMarksbgFrame.setSize(1920,1080);
                    enterMarksbgFrame.setLocation(0,0);
                    enterMarksbgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    enterMarksbgFrame.setLayout(null);

                    ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/Background2.png"));
                    Image img2 = img.getImage().getScaledInstance(1920, 1080,Image.SCALE_SMOOTH);
                    ImageIcon img3 = new ImageIcon(img2);

                    JLabel addBackgroundImage = new JLabel(img3);
                    addBackgroundImage.setBounds(0,0,1920,1080);
                    enterMarksbgFrame.add(addBackgroundImage);
                    enterMarksbgFrame.setUndecorated(true);
                    enterMarksbgFrame.setResizable(false);
                    enterMarksbgFrame.setVisible(true);

    
                    
        enterMarksFrame = new JFrame();
        enterMarksFrame.setSize(1100,600);
        enterMarksFrame.setLocation(400,200);
        enterMarksFrame.getContentPane().setBackground(Color.WHITE);
        enterMarksFrame.setLayout(null);
        enterMarksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
        //=========================Title of the form====================================

        title = new JLabel("Enter Student Marks");
        title.setBounds(350,10,500,50);
        title.setFont(new Font("Times New Roman",Font.BOLD,35));
        enterMarksFrame.add(title);
        
         
        
                
        
        
        /*======================Rollno Label=======================================*/
        rollNoLabel = new JLabel("Select Roll Number");
        rollNoLabel.setBounds(20,70,210,25);
        rollNoLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        enterMarksFrame.add(rollNoLabel);


        /*======================Adding Choice rollnumber bar====================================*/
        rollNoChoice = new Choice();
        rollNoChoice.setBounds(250,70,210,25);
        rollNoChoice.setFont(new Font("Times New Roman",Font.BOLD,20));
        enterMarksFrame.add(rollNoChoice);


            //Creating Connection and then addButton all roll number values into rollNoChoice bar    
            try {
                Conn connect = new Conn();
                ResultSet rs = connect.s.executeQuery("select * from students");//The resultset will store the whole result of the query given quotes
                while(rs.next()){
                    rollNoChoice.add(rs.getString("rollno")); //Adding the roolno column into Choice bar
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        /*======================Semester Label=======================================*/
        semesterLabel = new JLabel("Select semester");
        semesterLabel.setBounds(500,70,210,25);
        semesterLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        enterMarksFrame.add(semesterLabel);
        
        String sem[] = {"","1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester","6th Semester","7th Semester","8th Semester"};
        semesterComboBox = new JComboBox(sem);
        semesterComboBox.setBackground(Color.WHITE);
        semesterComboBox.setBounds(670,70,210,25);
        semesterComboBox.setFont(new Font("Times New Roman",Font.BOLD,20));
        semesterComboBox.setBackground(Color.WHITE);
        enterMarksFrame.add(semesterComboBox);
        
        
        
       /*======================Subject Code Label & it's 5 textfield==================================*/
        subjectCodeLabel = new JLabel("Subject Code");
        subjectCodeLabel.setBounds(20,150,150,25);
        subjectCodeLabel.setFont(new Font("Times New Roman",Font.BOLD,24));
        enterMarksFrame.add(subjectCodeLabel);
        
                
                sub1Code = new JTextField();
                sub1Code.setBounds(20,200,100,30);
                sub1Code.setFont(new Font("Times New Roman",Font.BOLD,21));
                enterMarksFrame.add(sub1Code);

                
                sub2Code = new JTextField();
                sub2Code.setBounds(20,250,100,30);
                sub2Code.setFont(new Font("Times New Roman",Font.BOLD,21));
                enterMarksFrame.add(sub2Code);


                sub3Code = new JTextField();
                sub3Code.setBounds(20,300,100,30);
                sub3Code.setFont(new Font("Times New Roman",Font.BOLD,21));
                enterMarksFrame.add(sub3Code);


                sub4Code = new JTextField();
                sub4Code.setBounds(20,350,100,30);
                sub4Code.setFont(new Font("Times New Roman",Font.BOLD,21));
                enterMarksFrame.add(sub4Code);


                sub5Code = new JTextField();
                sub5Code.setBounds(20,400,100,30);
                sub5Code.setFont(new Font("Times New Roman",Font.BOLD,21));
                enterMarksFrame.add(sub5Code);


                
        /*======================Subject & Mark Label==================================*/
        subjectLable = new JLabel("Enter Subjects");
        subjectLable.setBounds(200,150,210,25);
        subjectLable.setFont(new Font("Times New Roman",Font.BOLD,24));
        enterMarksFrame.add(subjectLable);
        
        
        marksLable = new JLabel("Enter Marks");
        marksLable.setBounds(550,150,210,25);
        marksLable.setFont(new Font("Times New Roman",Font.BOLD,24));
        enterMarksFrame.add(marksLable);
        
        
        
        /*======================Subject 1 & it's Marks textfield=================*/
        subject1TF = new JTextField();
        subject1TF.setBounds(200,200,250,30);
        subject1TF.setFont(new Font("Times New Roman",Font.BOLD,21));
        enterMarksFrame.add(subject1TF);
        //Using lambda to create a check on subject1TF so that user can only enter characters
            subject1TF.addKeyListener(new KeyAdapter() {

                public void keyPressed(KeyEvent ke) {

                    if ((((ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z') ) )|| (ke.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                       subject1TF.setEditable(true);

                    } else {
                       subject1TF.setEditable(false);
                    }
                }
            });
        
        
        
        
        subject1marksTF = new JTextField();
        subject1marksTF.setBounds(550,200,100,30);
        subject1marksTF.setFont(new Font("Times New Roman",Font.BOLD,21));
        enterMarksFrame.add(subject1marksTF);
        //Using lambda to create a check on subject1marksTF so that user can only enter number
            subject1marksTF.addKeyListener(new KeyAdapter() {

                public void keyPressed(KeyEvent ke) {

                    if (((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||ke.getKeyChar() == '.' )&&(subject1marksTF.getText().length()<5)|| (ke.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                       subject1marksTF.setEditable(true);

                    } else {
                       subject1marksTF.setEditable(false);
                    }
                }
            });
        
        
        
        /*======================Subject 2 & it's Marks textfield=================*/
        subject2TF = new JTextField();
        subject2TF.setBounds(200,250,250,30);
        subject2TF.setFont(new Font("Times New Roman",Font.BOLD,21));
        enterMarksFrame.add(subject2TF);
        //Using lambda to create a check on subject1TF so that user can only enter characters
            subject2TF.addKeyListener(new KeyAdapter() {

                public void keyPressed(KeyEvent ke) {

                    if ((((ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z') ) )|| (ke.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                       subject2TF.setEditable(true);

                    } else {
                       subject2TF.setEditable(false);
                    }
                }
            });
        
        
        subject2marksTF = new JTextField();
        subject2marksTF.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject2marksTF.setBounds(550,250,100,30);
        enterMarksFrame.add(subject2marksTF);
        //Using lambda to create a check on subject1marksTF so that user can only enter number
            subject2marksTF.addKeyListener(new KeyAdapter() {

                public void keyPressed(KeyEvent ke) {

                    if (((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||ke.getKeyChar() == '.' )&&(subject2marksTF.getText().length()<5)|| (ke.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                       subject2marksTF.setEditable(true);

                    } else {
                       subject2marksTF.setEditable(false);
                    }
                }
            });
        
        /*======================Subject 3 & it's Marks textfield=================*/
        subject3TF = new JTextField();
        subject3TF.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject3TF.setBounds(200,300,250,30);
        enterMarksFrame.add(subject3TF);
        //Using lambda to create a check on subject1TF so that user can only enter characters
            subject3TF.addKeyListener(new KeyAdapter() {

                public void keyPressed(KeyEvent ke) {

                    if ((((ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z') ) )|| (ke.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                       subject3TF.setEditable(true);

                    } else {
                       subject3TF.setEditable(false);
                    }
                }
            });
        
        
        
        subject3marksTF = new JTextField();
        subject3marksTF.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject3marksTF.setBounds(550,300,100,30);
        enterMarksFrame.add(subject3marksTF);
        //Using lambda to create a check on subject1marksTF so that user can only enter number
            subject3marksTF.addKeyListener(new KeyAdapter() {

                public void keyPressed(KeyEvent ke) {

                    if (((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||ke.getKeyChar() == '.' )&&(subject3marksTF.getText().length()<5)|| (ke.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                       subject3marksTF.setEditable(true);

                    } else {
                       subject3marksTF.setEditable(false);
                    }
                }
            });
        
        
        /*======================Subject 4 & it's Marks textfield=================*/
        subject4TF = new JTextField();
        subject4TF.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject4TF.setBounds(200,350,250,30);
        enterMarksFrame.add(subject4TF);
        //Using lambda to create a check on subject1TF so that user can only enter characters
            subject4TF.addKeyListener(new KeyAdapter() {

                public void keyPressed(KeyEvent ke) {

                    if ((((ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z') ) )|| (ke.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                       subject4TF.setEditable(true);

                    } else {
                       subject4TF.setEditable(false);
                    }
                }
            });
        
        subject4marksTF = new JTextField();
        subject4marksTF.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject4marksTF.setBounds(550,350,100,30);
        enterMarksFrame.add(subject4marksTF);
        //Using lambda to create a check on subject1marksTF so that user can only enter number
            subject4marksTF.addKeyListener(new KeyAdapter() {

                public void keyPressed(KeyEvent ke) {

                    if (((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||ke.getKeyChar() == '.' )&&(subject4marksTF.getText().length()<5)|| (ke.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                       subject4marksTF.setEditable(true);

                    } else {
                       subject4marksTF.setEditable(false);
                    }
                }
            });
        
        
        
        
        
        /*======================Subject 5 & it's Marks textfield=================*/
        subject5TF = new JTextField();
        subject5TF.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject5TF.setBounds(200,400,250,30);
        enterMarksFrame.add(subject5TF);
        //Using lambda to create a check on subject1TF so that user can only enter characters
            subject5TF.addKeyListener(new KeyAdapter() {

                public void keyPressed(KeyEvent ke) {

                    if ((((ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z') ) )|| (ke.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                       subject5TF.setEditable(true);

                    } else {
                       subject5TF.setEditable(false);
                    }
                }
            });    
            
            
        subject5marksTF = new JTextField();
        subject5marksTF.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject5marksTF.setBounds(550,400,100,30);
        enterMarksFrame.add(subject5marksTF);
        //Using lambda to create a check on subject1marksTF so that user can only enter number
            subject5marksTF.addKeyListener(new KeyAdapter() {

                public void keyPressed(KeyEvent ke) {

                    if (((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||ke.getKeyChar() == '.' )&&(subject5marksTF.getText().length()<5)|| (ke.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                       subject5marksTF.setEditable(true);

                    } else {
                       subject5marksTF.setEditable(false);
                    }
                }
            });
        

        
        
        
        /*=========================Image Icon====================*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/marksImage.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 350,Image.SCALE_SMOOTH);
        ImageIcon finalImageIcon = new ImageIcon(i2);
        

        JLabel addImage = new JLabel(finalImageIcon);
        addImage.setBounds(720,220,350,350);
        enterMarksFrame.add(addImage);
        
        
        
        /*=========================Submit Button Image Icon====================*/
        ImageIcon submitIcon = new ImageIcon(ClassLoader.getSystemResource("icons/SubmitButtonImage.png"));
        Image submit = submitIcon.getImage().getScaledInstance(200, 80, Image.SCALE_SMOOTH);
        ImageIcon submitFinalImageIcon = new ImageIcon(submit);
        
        
        submitButton=  new JButton(submitFinalImageIcon);
        submitButton.setBounds(400,503,190,60);
        enterMarksFrame.add(submitButton);

        // ADDING CURSOR SYMBOL 
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //SETTING BORDER TRANSPARENT
        submitButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        submitButton.setBackground(Color.WHITE);
        submitButton.addActionListener(this);
        

           
   
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
        enterMarksFrame.add(cancelButton);
        
        
        
        
        enterMarksFrame.setUndecorated(true);
        enterMarksFrame.setShape(new RoundRectangle2D.Double(0, 0, 1100, 600, 30, 30)); //This will make the edges rounded
        enterMarksFrame.setResizable(false);
        
        enterMarksFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new EnterMarks();
    }
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
    public void run() {
        
        try {
            
            Thread.sleep(1000);
            popupFailureImageFrame.dispose();
            enterMarksFrame.setVisible(true);
        } catch (InterruptedException ex) {
            System.out.println("Exception"+ex);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            enterMarksFrame.dispose();
            enterMarksbgFrame.dispose();
            
        }else if(e.getSource()  == submitButton){
         /*Here we are adding a validation if all the field are filled or not*/  
          
            String rollno = rollNoChoice.getSelectedItem();
            String sem = (String) semesterComboBox.getSelectedItem();
            
            String subCode1 = sub1Code.getText();
            String subCode2 = sub2Code.getText();
            String subCode3 = sub3Code.getText();
            String subCode4 = sub4Code.getText();
            String subCode5 = sub5Code.getText();
            
            String subject1 = subject1TF.getText();
            String subject2 = subject2TF.getText();
            String subject3 = subject3TF.getText();
            String subject4 = subject4TF.getText();
            String subject5 = subject5TF.getText();
            
            String mark1 = subject1marksTF.getText();
            String mark2 = subject2marksTF.getText();
            String mark3 = subject3marksTF.getText();
            String mark4 = subject4marksTF.getText();
            String mark5 = subject5marksTF.getText();
            
            String[] arr = {rollno,sem,subCode1,subCode2,subCode3,subCode4,subCode5
                                ,subject1,subject2,subject3,subject4,subject5
                                ,mark1,mark2,mark3,mark4,mark5
                           }; 
            boolean flag = true;
            for(String str:arr){
                if(str.isEmpty() == true){
                    flag = false;
                    enterMarksFrame.setVisible(false);
                    popUpFailureImage();
                    break;
                }
            }
            
            if(flag){
                    try {
                    Conn c= new Conn();

    //                String query1 = 
                    } catch (Exception ex) {
                    System.out.println("Exception"+ex);
                    
                    }
            }
            
        }
    }
    
    
}
