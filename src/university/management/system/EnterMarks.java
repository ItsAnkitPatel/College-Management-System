
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
public class EnterMarks {
    JFrame enterMarksFrame, enterMarksbgFrame;
    JLabel title,rollNoLabel,semesterLabel;
    Choice rollNoChoice;
    JComboBox semesterComboBox;
    
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
        semesterLabel.setBounds(20,130,210,25);
        semesterLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        enterMarksFrame.add(semesterLabel);
        
        String sem[] = {"","Semester1", "Semester2", "Semester3", "Semester4", "Semester5","Semester6","Semester7","Semester8"};
        semesterComboBox = new JComboBox(sem);
        semesterComboBox.setBounds(250,130,210,25);
        semesterComboBox.setFont(new Font("Times New Roman",Font.BOLD,20));
        semesterComboBox.setBackground(Color.WHITE);
        enterMarksFrame.add(semesterComboBox);
        
        

        

           
        
        
        
        
        
        
        enterMarksFrame.setUndecorated(true);
        enterMarksFrame.setShape(new RoundRectangle2D.Double(0, 0, 1100, 900, 30, 30)); //This will make the edges rounded
        enterMarksFrame.setResizable(false);
        
        enterMarksFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new EnterMarks();
    }
    
    
}
