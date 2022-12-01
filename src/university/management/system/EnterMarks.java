
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
public class EnterMarks implements ActionListener {
    JFrame enterMarksFrame, enterMarksbgFrame;
    JLabel title,rollNoLabel,semesterLabel;
    Choice rollNoChoice;
    JComboBox semesterComboBox;
    JButton cancelButton,submitButton;
    JLabel subjectLable,marksLable;
    JTextField subject1TF,subject2TF,subject3TF,subject4TF,subject5TF;
    JTextField subject1marksTF,subject2marksTF,subject3marksTF,subject4marksTF,subject5marksTF;
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
        enterMarksFrame.setSize(1100,900);
        enterMarksFrame.setLocation(400,80);
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
        
        
        
        
        /*======================Subject & Mark Label==================================*/
        subjectLable = new JLabel("Enter Subjects");
        subjectLable.setBounds(100,150,210,25);
        subjectLable.setFont(new Font("Times New Roman",Font.BOLD,24));
        enterMarksFrame.add(subjectLable);
        
        
        marksLable = new JLabel("Enter Marks");
        marksLable.setBounds(450,150,210,25);
        marksLable.setFont(new Font("Times New Roman",Font.BOLD,24));
        enterMarksFrame.add(marksLable);
        
        
        
        /*======================Subject 1 & marks textfield=================*/
        subject1TF = new JTextField();
        subject1TF.setBounds(100,200,250,30);
        enterMarksFrame.add(subject1TF);
        
        subject1marksTF = new JTextField();
        subject1marksTF.setBounds(450,200,100,30);
        enterMarksFrame.add(subject1marksTF);
        
        /*======================Subject 2 & marks textfield=================*/
        subject2TF = new JTextField();
        subject2TF.setBounds(100,250,250,30);
        enterMarksFrame.add(subject2TF);
        
        subject2marksTF = new JTextField();
        subject2marksTF.setBounds(450,250,100,30);
        enterMarksFrame.add(subject2marksTF);
        
        
        /*======================Subject 3 & marks textfield=================*/
        subject3TF = new JTextField();
        subject3TF.setBounds(100,300,250,30);
        enterMarksFrame.add(subject3TF);
        
        subject3marksTF = new JTextField();
        subject3marksTF.setBounds(450,300,100,30);
        enterMarksFrame.add(subject3marksTF);
        
        
        /*======================Subject 4 & marks textfield=================*/
        subject4TF = new JTextField();
        subject4TF.setBounds(100,350,250,30);
        enterMarksFrame.add(subject4TF);
        
        subject4marksTF = new JTextField();
        subject4marksTF.setBounds(450,350,100,30);
        enterMarksFrame.add(subject4marksTF);
        
        
        
        
        /*======================Subject 5 & marks textfield=================*/
        subject5TF = new JTextField();
        subject5TF.setBounds(100,400,250,30);
        enterMarksFrame.add(subject5TF);
        
        subject5marksTF = new JTextField();
        subject5marksTF.setBounds(450,400,100,30);
        enterMarksFrame.add(subject5marksTF);
        
        
        
        
        
        
        
        
        
        
        /*=========================Image Icon====================*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/marksImage.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400,Image.SCALE_SMOOTH);
        ImageIcon finalImageIcon = new ImageIcon(i2);
        

        JLabel addImage = new JLabel(finalImageIcon);
        addImage.setBounds(650,400,400,400);
        enterMarksFrame.add(addImage);
        
        
        
        /*=========================Submit Button Image Icon====================*/
        ImageIcon submitIcon = new ImageIcon(ClassLoader.getSystemResource("icons/SubmitButtonImage.png"));
        Image submit = submitIcon.getImage().getScaledInstance(200, 80, Image.SCALE_SMOOTH);
        ImageIcon submitFinalImageIcon = new ImageIcon(submit);
        
        
        submitButton=  new JButton(submitFinalImageIcon);
        submitButton.setBounds(465,770,190,60);
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
        cancelButton.setBounds(152,768,185,60);
        cancelButton.setBackground(Color.WHITE);
        
        // ADDING CURSOR SYMBOL 
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //SETTING BORDER TRANSPARENT
        cancelButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        cancelButton.addActionListener(this);
        enterMarksFrame.add(cancelButton);
        
        
        
        
        enterMarksFrame.setUndecorated(true);
        enterMarksFrame.setShape(new RoundRectangle2D.Double(0, 0, 1100, 900, 30, 30)); //This will make the edges rounded
        enterMarksFrame.setResizable(false);
        
        enterMarksFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new EnterMarks();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            enterMarksFrame.dispose();
            enterMarksbgFrame.dispose();
        }
    }
    
    
}
