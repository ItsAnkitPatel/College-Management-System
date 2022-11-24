
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;



public class AddStudent implements ActionListener,Runnable{
  static  boolean addStu = false;
  Thread t;
   JFrame studentFrame ;
   JFrame studentbgFrame ;
     int  threadNumber =0;
    
    JLabel nameLabel,fatherNameLabel,rollNumberLabel,
            phoneLabel,generatedRollNumber,emailLabel ,adhaarLabel,class10Label,class12Label;
    
    JTextField nameTextField,fatherNameTextField,
                phoneTextField,emailTextField,adhaarTextField,class10TextField,class12TextField;
    
    Random rm = new Random();
    long rollno = Math.abs((rm.nextLong()%9000L)+1000);  /*rm.nextLong %9000 will give -1 to 1 to ignore negative use Math.abs 
                                                 and we need only 4 digits that's why we are adding 1000*/
    
    JLabel DOB;
    JDateChooser dcdob ;
    
    
    JLabel addressLabel;
    JTextArea addressTextArea;

    
    
    JLabel courseLabel;
    JComboBox courseComboBox;
    
    JLabel branchLabel;
    JComboBox branchComboBox;
    
    JButton submitButton,cancelButton ;
    

    
    
    JFrame popupSuccessImageFrame ;
    JFrame popupFailureImageFrame ;
   
    


   void addStudentBackground() {
    /*============Adding Background image first*/
        studentbgFrame = new JFrame();
        studentbgFrame.setSize(1920,1080);
        studentbgFrame.setLocation(0,0);
        studentbgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentbgFrame.setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/Background3.png"));
        Image img2 = img.getImage().getScaledInstance(1920, 1080,Image.SCALE_SMOOTH);
        ImageIcon img3 = new ImageIcon(img2);
        
        JLabel addBackgroundImage = new JLabel(img3);
        addBackgroundImage.setBounds(0,0,1920,1080);
        studentbgFrame.add(addBackgroundImage);
        studentbgFrame.setUndecorated(true);
        studentbgFrame.setResizable(false);
        studentbgFrame.setVisible(true);

        
    }
    
    public AddStudent() {
        addStu = true;
        addStudentBackground();
      
        studentFrame = new JFrame();
        studentFrame.setSize(1100,900);
        studentFrame.setLocation(400,80);
        studentFrame.getContentPane().setBackground(Color.WHITE);
        studentFrame.setLayout(null);
        
        studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        
//=========================Title of the form====================================

        JLabel title = new JLabel("New Student Details");
        title.setBounds(350,20,500,50);
        title.setFont(new Font("Times New Roman",Font.BOLD,35));
        studentFrame.add(title);
        
        
        
        /*===========Name Label and it's Text field=================*/
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(100,100,100,50);
        nameLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        studentFrame.add(nameLabel);
        
        
        nameTextField = new JTextField();
        nameTextField.setBounds(200,110,250,30);
        nameTextField.setFont(new Font("Ubuntu Mono",Font.PLAIN,25));
        studentFrame.add(nameTextField);
        
        
        
        
        /*===========Father name Label and it's Text field=================*/
        fatherNameLabel = new JLabel("Father's Name");
        fatherNameLabel.setBounds(550,100,180,50);
        fatherNameLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        studentFrame.add(fatherNameLabel);
        
        
        fatherNameTextField = new JTextField();
        fatherNameTextField.setBounds(740,110,250,30);
        fatherNameTextField.setFont(new Font("Ubuntu Mono",Font.PLAIN,25));
        studentFrame.add(fatherNameTextField);
        
        
        
        
        
        /*===========Rollno Label and it's Text field=================*/
        rollNumberLabel = new JLabel("RollNo.");
        rollNumberLabel.setBounds(100,180,100,50);
        rollNumberLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        studentFrame.add(rollNumberLabel);
        
        
        generatedRollNumber = new JLabel("1533"+rollno);
        generatedRollNumber.setBounds(210,190,200,30);
        generatedRollNumber.setFont(new Font("Times New Roman",Font.PLAIN,25));
        studentFrame.add(generatedRollNumber);
        
        
        
        
        
        /*===========Date Of Birth Label and it's Text field=================*/
        DOB = new JLabel("Date of Birth");
        DOB.setBounds(550,180,180,50);
        DOB.setFont(new Font("Times New Roman",Font.BOLD,25));
        studentFrame.add(DOB);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(740,190,250,30);
        dcdob.setFont(new Font("Times New Roman",Font.PLAIN,20));
        studentFrame.add(dcdob);
        
        
        
        
        
        /*===========Address Label and it's Text field=================*/
        addressLabel = new JLabel("Address");
        addressLabel.setBounds(100,250,100,50);
        addressLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        studentFrame.add(addressLabel);
        
       
        
        addressTextArea = new JTextArea();
        addressTextArea.setLineWrap(true); //This will help to wrap the lines so it will not cross the border
        addressTextArea.setWrapStyleWord(true);
        addressTextArea.setFont(new Font("Times New Roman",Font.PLAIN,20));
        
        
        
        
        
        
            //============Adding scroll bar===================
        JScrollPane jsp = new JScrollPane(addressTextArea);
        jsp.setBounds(210,260,300,150);

        
        studentFrame.add(jsp);
                

        
        
        
        /*===========Phone number Label and it's Text field=================*/
        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(550,250,100,50);
        phoneLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        studentFrame.add(phoneLabel);
        
        
        phoneTextField = new JTextField();
        phoneTextField.setBounds(740,260,250,30);
        phoneTextField.setFont(new Font("Times New Roman",Font.PLAIN,25));
        studentFrame.add(phoneTextField);
        
        
        
        
        /*===========EmailID Label and it's Text field=================*/
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(550,320,100,50);
        emailLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        studentFrame.add(emailLabel);
        
        emailTextField = new JTextField();
        emailTextField.setBounds(740,330,250,30);
        emailTextField.setFont(new Font("Times New Roman",Font.PLAIN,25));
        studentFrame.add(emailTextField);
        
        
        
        
        
        /*===========AdhaarNo. Label and it's Text field=================*/
        adhaarLabel = new JLabel("AdhaarNo.");
        adhaarLabel.setBounds(550,380,130,50);
        adhaarLabel.setFont(new Font("Times New Roman",Font.BOLD,26));
        studentFrame.add(adhaarLabel);
        
        
        adhaarTextField = new JTextField();
        adhaarTextField.setBounds(740,385,250,30);
        adhaarTextField.setFont(new Font("Times New Roman",Font.PLAIN,24));
        studentFrame.add(adhaarTextField);
        
        
        
        
        /*===========Class 10th Label and it's Text field=================*/
        class10Label = new JLabel("Class X(%)");
        class10Label.setBounds(100,430,150,50);
        class10Label.setFont(new Font("Times New Roman",Font.BOLD,25));
        studentFrame.add(class10Label);
        
        
        class10TextField = new JTextField();
        class10TextField.setBounds(260,440,100,30);
        class10TextField.setFont(new Font("Times New Roman",Font.PLAIN,24));
        studentFrame.add(class10TextField);
        
        
        
        
        
        
        /*===========Class 12th Label and it's Text field=================*/
        class12Label = new JLabel("Class XII(%)");
        class12Label.setBounds(100,500,150,50);
        class12Label.setFont(new Font("Times New Roman",Font.BOLD,25));
        studentFrame.add(class12Label);
        
        
        class12TextField = new JTextField();
        class12TextField.setBounds(260,508,100,30);
        class12TextField.setFont(new Font("Times New Roman",Font.PLAIN,25));
        studentFrame.add(class12TextField);
        
        
        
        
        
        
        
        /*===========Course Label and it'scombo box=================*/
        courseLabel = new JLabel("Course");
        courseLabel.setBounds(100,580,150,50);
        courseLabel.setFont(new Font("Times New Roman",Font.BOLD,26));
        studentFrame.add(courseLabel);
        
        String[] courses = {"B.Tech","BBA","BCA","Bsc","Msc","MBA","MCA","MCom","MA","BA"};
        courseComboBox = new JComboBox(courses);
        courseComboBox.setBounds(260,595,200,25);
        courseComboBox.setFont(new Font("Times New Roman",Font.BOLD,20));
        courseComboBox.setBackground(Color.WHITE);
        studentFrame.add(courseComboBox);
        
        
        
        
        
        
        /*===========Branch Label and it's combo box =================*/
        branchLabel = new JLabel("Branch");
        branchLabel.setBounds(100,650,150,50);
        branchLabel.setFont(new Font("Times New Roman",Font.BOLD,26));
        studentFrame.add(branchLabel);
        
        
        String branch[] = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
        branchComboBox = new JComboBox(branch);
        branchComboBox.setFont(new Font("Times New Roman",Font.BOLD,18));
        branchComboBox.setBounds(260,664,200,25);
        branchComboBox.setBackground(Color.WHITE);
        
        studentFrame.add(branchComboBox);
        
        
        
        
        
        
        /*=========================Image Icon====================*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/AddDataImage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400,Image.SCALE_SMOOTH);
        ImageIcon finalImageIcon = new ImageIcon(i2);
        

        JLabel addImage = new JLabel(finalImageIcon);
        addImage.setBounds(700,500,400,400);
        studentFrame.add(addImage);
        
        
        
        
        
        /*=========================Submit Button Image Icon====================*/
        ImageIcon submitIcon = new ImageIcon(ClassLoader.getSystemResource("icons/SubmitButtonImage.png"));
        Image submit = submitIcon.getImage().getScaledInstance(200, 80, Image.SCALE_SMOOTH);
        ImageIcon submitFinalImageIcon = new ImageIcon(submit);
        
        
        
        submitButton=  new JButton(submitFinalImageIcon);
        submitButton.setBounds(465,750,190,60);
        studentFrame.add(submitButton);

        // ADDING CURSOR SYMBOL 
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //SETTING BORDER TRANSPARENT
        submitButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));        
//        submitButton.setBorder(new RoundedBorder(60));
        submitButton.setBackground(Color.WHITE);
        submitButton.addActionListener(this);
        

       
        
        /*=========================Cancel Button Image Icon====================*/
        
        
        ImageIcon cancelIcon = new ImageIcon(ClassLoader.getSystemResource("icons/CancelButtonImage.png"));
        Image cancel = cancelIcon.getImage().getScaledInstance(210, 85, Image.SCALE_SMOOTH);
        ImageIcon cancelFinalImageIcon = new ImageIcon(cancel);

        cancelButton=  new JButton(cancelFinalImageIcon);
        cancelButton.setBounds(152,748,185,60);
        cancelButton.setBackground(Color.WHITE);
        

        // ADDING CURSOR SYMBOL 
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //SETTING BORDER TRANSPARENT
        cancelButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        
        cancelButton.addActionListener(this);
        studentFrame.add(cancelButton);
        
        
        
        studentFrame.setUndecorated(true);
        studentFrame.setShape(new RoundRectangle2D.Double(0, 0, 1100, 900, 30, 30)); //This will make the edges rounded
        studentFrame.setResizable(false);
        
        studentFrame.setVisible(true);
    }
    
    


    void popUpSucessImage(){
               
        t = new Thread(this);
        popupSuccessImageFrame = new JFrame();
        popupSuccessImageFrame.setUndecorated(true); //removes the surrounding border

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/WorkDone.jpg")); //imports the image
        Image workDoneImage = image.getImage().getScaledInstance(500, 500,Image.SCALE_SMOOTH);
        ImageIcon finalworkDoneImageIcon = new ImageIcon(workDoneImage);
        JLabel lbl = new JLabel(finalworkDoneImageIcon); //puts the image into a jlabel

        popupSuccessImageFrame.getContentPane().add(lbl); //puts label inside the jframe

        
        popupSuccessImageFrame.setLocation(700,300);
        popupSuccessImageFrame.setSize(500,500);
        popupSuccessImageFrame.setShape(new RoundRectangle2D.Double(0, 0, 500, 500, 30, 30)); //This will make the edges rounded
        
        popupSuccessImageFrame.setVisible(true); //makes the jframe visible
        threadNumber =1;
        t.start();
        
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
        threadNumber =2;
        t.start();
        
    }
    

    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        
        if(e.getSource() == submitButton){
                
                String name = nameTextField.getText();
                String fname = fatherNameTextField.getText();
                String rollno = generatedRollNumber.getText();
                String dob =((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
                String address = addressTextArea.getText();
                String phone = phoneTextField.getText();
                String email = emailTextField.getText();
                String adhaar = adhaarTextField.getText();
                String class10 = class10TextField.getText();
                String class12 = class12TextField.getText();
                String course  = (String)courseComboBox.getSelectedItem();
                String branch = (String) branchComboBox.getSelectedItem();

                boolean flag = false;
                String[] strArray = {name,fname,rollno,dob,address,phone,adhaar,class10,class12,course,branch};

                int i =0;
                for(; i < strArray.length;i++){
                    if(strArray[i].isEmpty()){
                        break;
                    }
                }
                if(i>= strArray.length){
                flag = true;
                 }
        
            if(flag){
                studentFrame.dispose();

                try {//Creating mysql query

                String query = "insert into students values('"+name+"','"+fname+"','"+rollno+"',"
                        + "'"+dob+"','"+address+"','"+phone+"','"+email+"','"+adhaar+"','"+class10+"','"+class12+"','"+course+"','"+branch+"')";


                Conn connect = new Conn(); //Creating and Registering driver class
                connect.s.executeUpdate(query); //executeUpdate method use for DML commands in sql

                



            } catch (Exception ex) { 
                ex.printStackTrace();
            }
                
            popUpSucessImage(); //This line will only executed when the data is successfully inserted into the table
            }else{
                
                popUpFailureImage();
            }    
        
        }else if(e.getSource() == cancelButton){
            

            studentFrame.dispose();
            studentbgFrame.dispose();
            if(addStu == true && ShowStudentDetails.showStuDetail == false){
                addStu = false;
                Dashboard.dashboardFrame.setVisible(true);
                
            }else if(ShowStudentDetails.showStuDetail == true&&addStu == true ){
                ShowStudentDetails.showStuDetail = false;
                ShowStudentDetails.studentbgFrame.setVisible(true);
                ShowStudentDetails.studentDetailsframe.setVisible(true);
                
            }
        }
        
    }

    @Override
    public void run() {
        try {
            if(threadNumber ==1){//1 is for success 
               studentFrame.dispose();
                Thread.sleep(800);

                popupSuccessImageFrame.dispose();
                threadNumber =0;
                studentbgFrame.dispose();
                new AddStudent();
                
            }else if(threadNumber ==2 ){ // 2 is for failure 
                studentFrame.setVisible(false);
                threadNumber =0;
                Thread.sleep(1500);
                popupFailureImageFrame.dispose();
                studentFrame.setVisible(true);
               
            }     
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}