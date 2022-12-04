package university.management.system;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.geom.RoundRectangle2D;
import java.time.Year;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ShowMarks implements ActionListener{
    
//    public static void main(String[] args) {
//        new ShowMarks("");
//    }
    String rollNo;
    JFrame showMarksBgFrame,showMarksFrame;
    JLabel title,resultLabel;
    JButton exitButton;
    JLabel subjectCodeLabel,subjectLable,marksLable;
    JLabel sub1Code,sub2Code,sub3Code,sub4Code,sub5Code;
    JLabel subject1TF,subject2TF,subject3TF,subject4TF,subject5TF;
    JLabel subject1marksTF,subject2marksTF,subject3marksTF,subject4marksTF,subject5marksTF;
    public ShowMarks(String rollNo) {
            this.rollNo =rollNo;    
        
             /*============Adding Background image first=================*/
                    showMarksBgFrame = new JFrame();
                    showMarksBgFrame.setSize(1920,1080);
                    showMarksBgFrame.setLocation(0,0);
                    showMarksBgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    showMarksBgFrame.setLayout(null);

                    ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/Background3.png"));
                    Image img2 = img.getImage().getScaledInstance(1920, 1080,Image.SCALE_SMOOTH);
                    ImageIcon img3 = new ImageIcon(img2);

                    JLabel addBackgroundImage = new JLabel(img3);
                    addBackgroundImage.setBounds(0,0,1920,1080);
                    showMarksBgFrame.add(addBackgroundImage);
                    showMarksBgFrame.setUndecorated(true);
                    showMarksBgFrame.setResizable(false);
                    showMarksBgFrame.setVisible(true);
        
                    
        showMarksFrame = new JFrame();
        showMarksFrame.setSize(750,800);
        showMarksFrame.setLocation(550, 100);
        showMarksFrame.getContentPane().setBackground(Color.WHITE);
        showMarksFrame.setLayout(null);
        showMarksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //=========================Title of the form====================================

        title = new JLabel("Dummy Technical University");
        title.setBounds(150,10,500,50);
        title.setFont(new Font("Times New Roman",Font.BOLD,35));
        showMarksFrame.add(title);
        
        int year = Year.now().getValue(); //This will fetch the current year of your system
        
        resultLabel = new JLabel("Result of Examination "+year);
        resultLabel.setBounds(180,60,500,50);
        resultLabel.setFont(new Font("Times New Roman",Font.BOLD,30));
        showMarksFrame.add(resultLabel);
        
        
        
        
        
        
        
        
        
        /*======================Subject Code Label & it's 5 textfield==================================*/
        subjectCodeLabel = new JLabel("Subject Code");
        subjectCodeLabel.setBounds(20,150,150,25);
        subjectCodeLabel.setFont(new Font("Times New Roman",Font.BOLD,24));
        showMarksFrame.add(subjectCodeLabel);
        
                
                sub1Code = new JLabel();
                sub1Code.setBounds(20,200,100,30);
                sub1Code.setFont(new Font("Times New Roman",Font.BOLD,21));
                showMarksFrame.add(sub1Code);

                
                sub2Code = new JLabel();
                sub2Code.setBounds(20,250,100,30);
                sub2Code.setFont(new Font("Times New Roman",Font.BOLD,21));
                showMarksFrame.add(sub2Code);


                sub3Code = new JLabel();
                sub3Code.setBounds(20,300,100,30);
                sub3Code.setFont(new Font("Times New Roman",Font.BOLD,21));
                showMarksFrame.add(sub3Code);


                sub4Code = new JLabel();
                sub4Code.setBounds(20,350,100,30);
                sub4Code.setFont(new Font("Times New Roman",Font.BOLD,21));
                showMarksFrame.add(sub4Code);


                sub5Code = new JLabel();
                sub5Code.setBounds(20,400,100,30);
                sub5Code.setFont(new Font("Times New Roman",Font.BOLD,21));
                showMarksFrame.add(sub5Code);


                
        /*======================Subject & Mark Label==================================*/
        subjectLable = new JLabel("Semester Subjects");
        subjectLable.setBounds(200,150,210,25);
        subjectLable.setFont(new Font("Times New Roman",Font.BOLD,24));
        showMarksFrame.add(subjectLable);
        
        
        marksLable = new JLabel("Marks");
        marksLable.setBounds(550,150,210,25);
        marksLable.setFont(new Font("Times New Roman",Font.BOLD,24));
        showMarksFrame.add(marksLable);
        
        
        
        /*======================Subject 1 & it's Marks textfield=================*/
        subject1TF = new JLabel();
        subject1TF.setBounds(200,200,250,30);
        subject1TF.setFont(new Font("Times New Roman",Font.BOLD,21));
        showMarksFrame.add(subject1TF);
        
        
        
        subject1marksTF = new JLabel();
        subject1marksTF.setBounds(550,200,100,30);
        subject1marksTF.setFont(new Font("Times New Roman",Font.BOLD,21));
        showMarksFrame.add(subject1marksTF);
        
        
        
        /*======================Subject 2 & it's Marks textfield=================*/
        subject2TF = new JLabel();
        subject2TF.setBounds(200,250,250,30);
        subject2TF.setFont(new Font("Times New Roman",Font.BOLD,21));
        showMarksFrame.add(subject2TF);
        
        
        subject2marksTF = new JLabel();
        subject2marksTF.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject2marksTF.setBounds(550,250,100,30);
        showMarksFrame.add(subject2marksTF);
       
        
        /*======================Subject 3 & it's Marks textfield=================*/
        subject3TF = new JLabel();
        subject3TF.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject3TF.setBounds(200,300,250,30);
        showMarksFrame.add(subject3TF);
        
        
        
        subject3marksTF = new JLabel();
        subject3marksTF.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject3marksTF.setBounds(550,300,100,30);
        showMarksFrame.add(subject3marksTF);
       
        
        /*======================Subject 4 & it's Marks textfield=================*/
        subject4TF = new JLabel();
        subject4TF.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject4TF.setBounds(200,350,250,30);
        showMarksFrame.add(subject4TF);
       
        
        subject4marksTF = new JLabel();
        subject4marksTF.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject4marksTF.setBounds(550,350,100,30);
        showMarksFrame.add(subject4marksTF);
        
        
        
        /*======================Subject 5 & it's Marks textfield=================*/
        subject5TF = new JLabel();
        subject5TF.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject5TF.setBounds(200,400,250,30);
        showMarksFrame.add(subject5TF);
        
            
        subject5marksTF = new JLabel();
        subject5marksTF.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject5marksTF.setBounds(550,400,100,30);
        showMarksFrame.add(subject5marksTF);
        
        
        
        try {
            Conn c= new Conn();
            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno='"+rollNo+"'");

            
        

            while(rs1.next()){
                sub1Code.setText(rs1.getString("code1"));
                sub2Code.setText(rs1.getString("code2"));
                sub3Code.setText(rs1.getString("code3"));
                sub4Code.setText(rs1.getString("code4"));
                sub5Code.setText(rs1.getString("code5"));
                
                
                subject1TF.setText(rs1.getString("subject1"));
                subject2TF.setText(rs1.getString("subject2"));
                subject3TF.setText(rs1.getString("subject3"));
                subject4TF.setText(rs1.getString("subject4"));
                subject5TF.setText(rs1.getString("subject5"));

                
            }
            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno='"+rollNo+"'");
            while(rs2.next()){
                subject1marksTF.setText(rs2.getString("marks1"));
                subject2marksTF.setText(rs2.getString("marks2"));
                subject3marksTF.setText(rs2.getString("marks3"));
                subject4marksTF.setText(rs2.getString("marks4"));
                subject5marksTF.setText(rs2.getString("marks5"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        
        
         /*=========================Image Icon====================*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ShowMarksImage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 300,Image.SCALE_SMOOTH);
        ImageIcon finalImageIcon = new ImageIcon(i2);
        

        JLabel addImage = new JLabel(finalImageIcon);
        addImage.setBounds(30,490,700,300);
        showMarksFrame.add(addImage);
        
        
        
        
        
        //=================================ExitImage + Text + Button=====================================================
        
                ImageIcon exitImage= new ImageIcon(ClassLoader.getSystemResource("icons/ExitImage.png"));
                Image exit = exitImage.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
                ImageIcon exit2 = new ImageIcon(exit);



                //=========Exit Text======================
                JLabel exitText = new JLabel("EXIT");
                exitText.setBounds(700,470,100,30);
                showMarksFrame.add(exitText);


                //=========Exit Button==================== 

                exitButton = new JButton(exit2);
                exitButton.setBounds(670, 420, 60, 50);
                exitButton.setBackground(new Color(0,0,0,0));
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;

                //SETTING BORDER TRANSPARENT
                exitButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

                exitButton.addActionListener(this);
                showMarksFrame.add(exitButton);

        
                
        showMarksFrame.setUndecorated(true);
        showMarksFrame.setShape(new RoundRectangle2D.Double(0, 0, 750,800,30, 30)); //This will make the edges rounded
        showMarksFrame.setResizable(false);
        
        showMarksFrame.setVisible(true);
        
    }

    @Override
    public void  actionPerformed(ActionEvent ae){
        if(ae.getSource() == exitButton){
            showMarksFrame.dispose();
            showMarksBgFrame.dispose();
            new ExaminationDetails();
                    
        }
    }

    
    
    
}
