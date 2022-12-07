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
    

    String rollNo;
    JFrame showMarksBgFrame,showMarksFrame;
    JLabel title,resultLabel;
    JButton exitButton;
    JLabel subjectCodeLabel,subjectLable,marksLable;
    JLabel sub1Code,sub2Code,sub3Code,sub4Code,sub5Code;
    JLabel subject1LB,subject2LB,subject3LB,subject4LB,subject5LB;
    JLabel subject1marksLB,subject2marksLB,subject3marksLB,subject4marksLB,subject5marksLB;
    JLabel rollNoLabel,showrollNoLabel,
            semeseterLabel,showSemLabel;

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
        showMarksFrame.setSize(750,850);
        showMarksFrame.setLocation(550, 100);
        showMarksFrame.getContentPane().setBackground(Color.WHITE);
        showMarksFrame.setLayout(null);
        showMarksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showMarksFrame.setUndecorated(true);
        showMarksFrame.setShape(new RoundRectangle2D.Double(0, 0, 750,850,30, 30)); //This will make the edges rounded
        showMarksFrame.setResizable(false);
        
/*============================================Title of the form ========================================================*/

        title = new JLabel("Dummy Technical University");
        title.setBounds(150,10,500,50);
        title.setFont(new Font("Times New Roman",Font.BOLD,35));
        showMarksFrame.add(title);
        
        int year = Year.now().getValue(); //This will fetch the current year of your system
        
        resultLabel = new JLabel("Result of Examination "+year);
        resultLabel.setBounds(180,60,500,50);
        resultLabel.setFont(new Font("Times New Roman",Font.BOLD,30));
        showMarksFrame.add(resultLabel);
        
        
        
 /*==========================================Rollno Label==================================================================*/
            rollNoLabel = new JLabel("Roll No. :");
            rollNoLabel.setBounds(10,120,100,25);
            rollNoLabel.setFont(new Font("Times New Roman",Font.BOLD,23));
            showMarksFrame.add(rollNoLabel);


            showrollNoLabel = new JLabel();
            showrollNoLabel.setBounds(110,120,120,25);
            showrollNoLabel.setFont(new Font("Times New Roman",Font.BOLD,23));
            showMarksFrame.add(showrollNoLabel);
            
            
            
/*==================================Semester Label and Show semester label=================================================*/
            semeseterLabel = new JLabel("Sem:");
            semeseterLabel.setBounds(400,120,60,25);
            semeseterLabel.setFont(new Font("Times New Roman",Font.BOLD,23));
            showMarksFrame.add(semeseterLabel);

            showSemLabel = new JLabel();
            showSemLabel.setBounds(460,120,200,25);
            showSemLabel.setFont(new Font("Times New Roman",Font.BOLD,23));
            showMarksFrame.add(showSemLabel);

        
        
/*==============================Subject Code Label & it's 5 subject labela======================================================*/
        
        subjectCodeLabel = new JLabel("Subject Code");
        subjectCodeLabel.setBounds(20,180,150,25);
        subjectCodeLabel.setFont(new Font("Times New Roman",Font.BOLD,24));
        showMarksFrame.add(subjectCodeLabel);
        
                
                sub1Code = new JLabel();
                sub1Code.setBounds(20,230,100,30);
                sub1Code.setFont(new Font("Times New Roman",Font.BOLD,21));
                showMarksFrame.add(sub1Code);

                
                sub2Code = new JLabel();
                sub2Code.setBounds(20,280,100,30);
                sub2Code.setFont(new Font("Times New Roman",Font.BOLD,21));
                showMarksFrame.add(sub2Code);


                sub3Code = new JLabel();
                sub3Code.setBounds(20,330,100,30);
                sub3Code.setFont(new Font("Times New Roman",Font.BOLD,21));
                showMarksFrame.add(sub3Code);


                sub4Code = new JLabel();
                sub4Code.setBounds(20,380,100,30);
                sub4Code.setFont(new Font("Times New Roman",Font.BOLD,21));
                showMarksFrame.add(sub4Code);


                sub5Code = new JLabel();
                sub5Code.setBounds(20,430,100,30);
                sub5Code.setFont(new Font("Times New Roman",Font.BOLD,21));
                showMarksFrame.add(sub5Code);
                
/*================================Subject & Mark Labels====================================================*/
        subjectLable = new JLabel("Semester Subjects");
        subjectLable.setBounds(200,180,210,25);
        subjectLable.setFont(new Font("Times New Roman",Font.BOLD,24));
        showMarksFrame.add(subjectLable);
        
        
        marksLable = new JLabel("Marks");
        marksLable.setBounds(550,180,210,25);
        marksLable.setFont(new Font("Times New Roman",Font.BOLD,24));
        showMarksFrame.add(marksLable);
        
        
        
        /*======================Subject 1 & it's Marks Label=================*/
        subject1LB = new JLabel();
        subject1LB.setBounds(200,230,250,30);
        subject1LB.setFont(new Font("Times New Roman",Font.BOLD,21));
        showMarksFrame.add(subject1LB);
        
        
        
        subject1marksLB = new JLabel();
        subject1marksLB.setBounds(550,230,100,30);
        subject1marksLB.setFont(new Font("Times New Roman",Font.BOLD,21));
        showMarksFrame.add(subject1marksLB);
        
        
        
        /*======================Subject 2 & it's Marks Label=================*/
        subject2LB = new JLabel();
        subject2LB.setBounds(200,280,250,30);
        subject2LB.setFont(new Font("Times New Roman",Font.BOLD,21));
        showMarksFrame.add(subject2LB);
        
        
        subject2marksLB = new JLabel();
        subject2marksLB.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject2marksLB.setBounds(550,280,100,30);
        showMarksFrame.add(subject2marksLB);
       
        
        /*======================Subject 3 & it's Marks Label=================*/
        subject3LB = new JLabel();
        subject3LB.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject3LB.setBounds(200,330,250,30);
        showMarksFrame.add(subject3LB);
        
        
        
        subject3marksLB = new JLabel();
        subject3marksLB.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject3marksLB.setBounds(550,330,100,30);
        showMarksFrame.add(subject3marksLB);
       
        
        /*======================Subject 4 & it's Marks Label=================*/
        subject4LB = new JLabel();
        subject4LB.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject4LB.setBounds(200,380,250,30);
        showMarksFrame.add(subject4LB);
       
        
        subject4marksLB = new JLabel();
        subject4marksLB.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject4marksLB.setBounds(550,380,100,30);
        showMarksFrame.add(subject4marksLB);
        
        
        
        /*======================Subject 5 & it's Marks Label=================*/
        subject5LB = new JLabel();
        subject5LB.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject5LB.setBounds(200,430,250,30);
        showMarksFrame.add(subject5LB);
        
            
        subject5marksLB = new JLabel();
        subject5marksLB.setFont(new Font("Times New Roman",Font.BOLD,21));
        subject5marksLB.setBounds(550,430,100,30);
        showMarksFrame.add(subject5marksLB);
        
        
  /*==============================Fetching all data from database and updating all the fields========================*/
        try {
            Conn c= new Conn();
            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno='"+rollNo+"'");
            while(rs1.next()){
                sub1Code.setText(rs1.getString("code1"));
                sub2Code.setText(rs1.getString("code2"));
                sub3Code.setText(rs1.getString("code3"));
                sub4Code.setText(rs1.getString("code4"));
                sub5Code.setText(rs1.getString("code5"));
                
                
                subject1LB.setText(rs1.getString("subject1"));
                subject2LB.setText(rs1.getString("subject2"));
                subject3LB.setText(rs1.getString("subject3"));
                subject4LB.setText(rs1.getString("subject4"));
                subject5LB.setText(rs1.getString("subject5"));

                showrollNoLabel.setText(rs1.getString("rollno"));
                showSemLabel.setText(rs1.getString("semester"));
            }
            
            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno='"+rollNo+"'");
            while(rs2.next()){
                subject1marksLB.setText(rs2.getString("marks1"));
                subject2marksLB.setText(rs2.getString("marks2"));
                subject3marksLB.setText(rs2.getString("marks3"));
                subject4marksLB.setText(rs2.getString("marks4"));
                subject5marksLB.setText(rs2.getString("marks5"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
/*=======================================Image Icon==============================================================*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ShowMarksImage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 300,Image.SCALE_SMOOTH);
        ImageIcon finalImageIcon = new ImageIcon(i2);
        

        JLabel addImage = new JLabel(finalImageIcon);
        addImage.setBounds(30,550,700,300);
        showMarksFrame.add(addImage);
        
        
        
/*=================================ExitImage + Text + Button=====================================================*/
        
                ImageIcon exitImage= new ImageIcon(ClassLoader.getSystemResource("icons/ExitImage.png"));
                Image exit = exitImage.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
                ImageIcon exit2 = new ImageIcon(exit);


                //=========Exit Text======================
                JLabel exitText = new JLabel("EXIT");
                exitText.setBounds(700,510,100,30);
                showMarksFrame.add(exitText);


                //=========Exit Button==================== 

                exitButton = new JButton(exit2);
                exitButton.setBounds(670, 450, 60, 50);
                exitButton.setBackground(new Color(0,0,0,0));
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;

                //SETTING BORDER TRANSPARENT
                exitButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                
                // ADDING CURSOR SYMBOL 
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                exitButton.addActionListener(this);
                showMarksFrame.add(exitButton);
/*==============================================THE END===========================================================*/
        
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
