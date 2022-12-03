package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Dashboard implements ActionListener{
    static JFrame dashboardFrame ;
   
    Dashboard() {
        
        dashboardFrame = new JFrame();
        
        Font font1 = new Font("FreeSerif", Font.BOLD, 18);
        dashboardFrame.setSize(1920,1080);
        dashboardFrame.setBackground(Color.WHITE);
        dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/AnimatedCollege.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1000,Image.SCALE_DEFAULT);
        ImageIcon finalImageIcon = new ImageIcon(i2);
        
        JLabel addImage = new JLabel(finalImageIcon);
        dashboardFrame.add(addImage);
        
        //===========Setting Dimenstions for JMenuItem================
        Dimension dimension = new Dimension(100,50);
        Dimension dimension2 = new Dimension(220,50);
        
        
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(dimension);

//============================== New Information ==========================================================
        JMenu newInformation = new JMenu("New Information");
        newInformation.setFont(font1);
        newInformation.setForeground(Color.BLUE);
        menuBar.add(newInformation);
        
        //==========Menu Items==============================================
        
        
        JMenuItem facultyInfo = new JMenuItem("Add new Faculty Information");
        facultyInfo.setPreferredSize(dimension);
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        
        JMenuItem studentInfo = new JMenuItem("Add new Student Information");      
        studentInfo.setPreferredSize(dimension2);
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        
 //============================== Details ==========================================================       
        

        JMenu details = new JMenu("View Details");
        details.setFont(font1);
        details.setForeground(Color.RED);
        menuBar.add(details);

        
        //=======================Details menu items=================
        
        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setPreferredSize(dimension);
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);
        
        
        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setPreferredSize(new Dimension(170,50));
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        details.add(studentDetails);
        
//============================== Examination ==========================================================               


        JMenu exam = new JMenu("Examination");
        exam.setFont(font1);
        exam.setForeground(Color.BLUE);
        menuBar.add(exam);
        //=======================Exam menu items=================
        JMenuItem examinationDetails = new JMenuItem("Exam Results");
        examinationDetails.setPreferredSize(dimension);
        examinationDetails.setBackground(Color.WHITE);
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);
        
        
        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setPreferredSize(new Dimension(120,50));
        enterMarks.setBackground(Color.WHITE);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);
        
        
//============================== Update Info ==========================================================               


        JMenu upadteInfo = new JMenu("Update Information");
        upadteInfo.setFont(font1);
        upadteInfo.setForeground(Color.RED);
        menuBar.add(upadteInfo);
            //=======================Update menu items=================
        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Details");
        updateFacultyInfo.setPreferredSize(dimension);
        updateFacultyInfo.setBackground(Color.WHITE);
        updateFacultyInfo.addActionListener(this);
        upadteInfo.add(updateFacultyInfo);
        
        
        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
        updateStudentInfo.setPreferredSize(dimension2);
        updateStudentInfo.setBackground(Color.WHITE);
        updateStudentInfo.addActionListener(this);
        upadteInfo.add(updateStudentInfo);
        
        
        
//============================== Fee Info ==========================================================               


        JMenu fee = new JMenu("Fee Details");
        fee.setFont(font1);
        fee.setForeground(Color.BLUE);
        menuBar.add(fee);
        
        
        //=======================Fees menu items=================
        JMenuItem feeStructure = new JMenuItem("Fees Structure");
        feeStructure.setPreferredSize(dimension);
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);        
        
        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setPreferredSize(new Dimension(150,50));
        feeForm.setBackground(Color.WHITE);
        feeForm.addActionListener(this);
        fee.add(feeForm);



//============================== Utility ==========================================================               
        JMenu utility = new JMenu("Utility");
        utility.setFont(font1);
        utility.setForeground(Color.RED);
        menuBar.add(utility);
        
        
        //=======================Utility menu items=================
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setPreferredSize(dimension);
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setPreferredSize(new Dimension(100,50));
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);

 

        dashboardFrame.setJMenuBar(menuBar);
  
        dashboardFrame.setVisible(true);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        
        if(msg.equals("Add new Student Information")){
            dashboardFrame.setVisible(false);
            new AddStudent();
           
        }else if( msg.equals("Add new Faculty Information")){
            dashboardFrame.setVisible(false);
            new AddTeacher();
            
        }
        
        
        else if(msg.equals("View Faculty Details")){
            dashboardFrame.setVisible(false);
             new ShowTeacherDetails();     
        }
        
        else if(msg.equals("View Student Details")){
            dashboardFrame.setVisible(false);
            new ShowStudentDetails();
            
        }
        
        else if(msg.equals("Exam Results")){
            dashboardFrame.setVisible(false);
            new ExaminationDetails();
            
            
        }
        
        else if(msg.equals("Enter Marks")){
            dashboardFrame.setVisible(false);         
            new EnterMarks();
            
            
        }
        
        else if(msg.equals("Update Faculty Details")){
            dashboardFrame.setVisible(false);
            new UpdateTeacher();
            
            
        }
        
        else if(msg.equals("Update Student Details")){
            dashboardFrame.setVisible(false);
            new UpdateStudent();
            
            
        }
        
        else if(msg.equals("Fees Structure")){
            
        }
        
        else if(msg.equals("Student Fee Form")){
            
            
        }
        
        else if(msg.equals("Calculator")){
            try {
                Runtime.getRuntime().exec("gnome-calculator");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            
            
        }else if(msg.equals("Notepad")){
            
            try {
                Runtime.getRuntime().exec("gedit");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
                
        }
        
            
    }
    
}
