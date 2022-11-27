package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;



public class AddStudent implements ActionListener,Runnable{
   

  JLabel showMessage1,showMessage2,showMessage3,showMessage4,showMessage5,showMessage6,showMessage7,showMessage8,showMessage9,showMessage10,showMessage11;
  
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
   
    

    public static void main(String[] args) {
        new AddStudent();
    }
   
    public AddStudent() {
        
        
      
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
        
        //Using lambda to create a check on phoneTextField so that user can only enter numbers
            phoneTextField.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                       if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')&&(phoneTextField.getText().length()<10)||(ke.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                          phoneTextField.setEditable(true);

                       } else {
                          phoneTextField.setEditable(false);
                       }
                }
             });
        
        
        
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
        adhaarLabel.setBounds(550,390,130,50);
        adhaarLabel.setFont(new Font("Times New Roman",Font.BOLD,26));
        studentFrame.add(adhaarLabel);
        
        
        adhaarTextField = new JTextField();
        adhaarTextField.setBounds(740,395,250,30);
        adhaarTextField.setFont(new Font("Times New Roman",Font.PLAIN,24));
        studentFrame.add(adhaarTextField);
        
        //Using lambda to create a check on adhaarTextField so that user can only enter numbers
            adhaarTextField.addKeyListener(new KeyAdapter() {

                public void keyPressed(KeyEvent ke) {

                    if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')&&(adhaarTextField.getText().length()<12)||(ke.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                       adhaarTextField.setEditable(true);

                    } else {
                       adhaarTextField.setEditable(false);
                    }
                }
            });
        
        
        
        
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
        
        String[] courses = {"","B.Tech","BBA","BCA","Bsc","Msc","MBA","MCA","MCom","MA","BA"};
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
        
        
        String branch[] = {"","Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
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
        
        
        
         /*Creating object of all message lables and making them invisible for the time*/
                
                //Message1 
                showMessage1 = new JLabel("You cannot left this field empty");
                showMessage1.setFont(new Font("serif",Font.PLAIN,12));
                showMessage1.setBounds(nameTextField.getX(),nameTextField.getY()+30,200,20);
                studentFrame.add(showMessage1);
                showMessage1.setVisible(false);
                 
                 
                //Message2 
                showMessage2 = new JLabel("You cannot left this field empty");
                showMessage2.setFont(new Font("serif",Font.PLAIN,12));
                showMessage2.setBounds(fatherNameTextField.getX(),fatherNameTextField.getY()+30,200,20);
                studentFrame.add(showMessage2);
                showMessage2.setVisible(false);
                
                //Message3
                showMessage3 = new JLabel("You cannot left this field empty");
                showMessage3.setFont(new Font("serif",Font.PLAIN,12));
                showMessage3.setBounds(740,225,200,20);
                studentFrame.add(showMessage3);
                showMessage3.setVisible(false);
                
                //Message4
                showMessage4= new JLabel("You cannot left this field empty");
                showMessage4.setFont(new Font("serif",Font.PLAIN,12));
                showMessage4.setBounds(210,415,210,20);
                studentFrame.add(showMessage4);
                showMessage4.setVisible(false);
                
                //Message5
                showMessage5 = new JLabel("You cannot left this field empty");
                showMessage5.setFont(new Font("serif",Font.PLAIN,12));
                showMessage5.setBounds(phoneTextField.getX(),phoneTextField.getY()+30,200,20);
                studentFrame.add(showMessage5);
                showMessage5.setVisible(false);
                
                //Message6
                showMessage6 = new JLabel("You cannot left this field empty");
                showMessage6.setFont(new Font("serif",Font.PLAIN,12));
                showMessage6.setBounds(emailTextField.getX(),emailTextField.getY()+30,200,20);
                studentFrame.add(showMessage6);
                showMessage6.setVisible(false);
        
                //Message7
                showMessage7 = new JLabel("You cannot left this field empty");
                showMessage7.setFont(new Font("serif",Font.PLAIN,12));
                showMessage7.setBounds(adhaarTextField.getX(),adhaarTextField.getY()+30,200,20);
                studentFrame.add(showMessage7);
                showMessage7.setVisible(false);
                
                //Message8
                showMessage8 = new JLabel("You cannot left this field empty");
                showMessage8.setFont(new Font("serif",Font.PLAIN,12));
                showMessage8.setBounds(class10TextField.getX(),class10TextField.getY()+30,200,20);
                studentFrame.add(showMessage8);
                showMessage8.setVisible(false);
                
                //Message9
                showMessage9 = new JLabel("You cannot left this field empty");
                showMessage9.setFont(new Font("serif",Font.PLAIN,12));
                showMessage9.setBounds(class12TextField.getX(),class12TextField.getY()+30,200,20);
                studentFrame.add(showMessage9);
                showMessage9.setVisible(false);
                
                //Message10
                showMessage10 = new JLabel("You cannot left this field empty");
                showMessage10.setFont(new Font("serif",Font.PLAIN,12));
                showMessage10.setBounds(courseComboBox.getX(),courseComboBox.getY()+30,200,20);
                studentFrame.add(showMessage10);
                showMessage10.setVisible(false);
                
                //Message11
                showMessage11 = new JLabel("You cannot left this field empty");
                showMessage11.setFont(new Font("serif",Font.PLAIN,12));
                showMessage11.setBounds(branchComboBox.getX(),branchComboBox.getY()+30,200,20);
                studentFrame.add(showMessage11);
                showMessage11.setVisible(false);
                
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
    
    void checkFormatIsCorrect(){
        
    }
    
    
    
    void isEmpty(int i){
        switch (i) {
            case 0:
               nameTextField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
               showMessage1.setVisible(true);
               break;
               
            case 1:
                fatherNameTextField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                showMessage2.setVisible(true);
                break;
                
            case 2:
                dcdob.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                showMessage3.setVisible(true);
                break;
            
            case 3:
                addressTextArea.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                showMessage4.setVisible(true);
                break;
            
            case 4:
                phoneTextField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                showMessage5.setVisible(true);
                break;
            
            case 5:
                emailTextField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                showMessage6.setVisible(true);
                break;
            
            case 6:
                adhaarTextField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                showMessage7.setVisible(true);
                break;
            
            case 7:
                class10TextField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                showMessage8.setVisible(true);
                break;
                
            case 8:
                class12TextField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                showMessage9.setVisible(true);
                break;
                
            case 9:
                courseComboBox.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                showMessage10.setVisible(true);
                break;
            
            case 10:
                branchComboBox.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                showMessage11.setVisible(true);
                break;
                
        }
        
    }
    

    
    void changeBorderColorToBlack(int num){//This will executed when we hit the update submit button , 
                                  //the only reason we are doing this because we dont want to keep showing
                                  //the red color even though the user filled the empty field
        switch (num) {
            case 0:
                nameTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                showMessage1.setVisible(false);
                break;
                
            case 1:
                fatherNameTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                showMessage2.setVisible(false);
                break;
                
            case 2:
               dcdob.setBorder(BorderFactory.createLineBorder(Color.GRAY));
               showMessage3.setVisible(false);
               break;
               
            case 3:
              addressTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
              showMessage4.setVisible(false);
               break;
               
            case 4:
                phoneTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                showMessage5.setVisible(false);
                break;
                
            case 5:
                 emailTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                 showMessage6.setVisible(false);
                 break;
                 
            case 6:
                adhaarTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                showMessage7.setVisible(false);
                break;
                
            case 7:
                class10TextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));        
                showMessage8.setVisible(false);
                break;
                
            case 8:
                class12TextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                showMessage9.setVisible(false);
                break;
                
            case 9:
                courseComboBox.setBorder(BorderFactory.createLineBorder(Color.GRAY));                
                showMessage10.setVisible(false);
                break;
                
            case 10:
                 branchComboBox.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                 showMessage11.setVisible(false);
                break;
        }
        
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

                boolean flag = true;
                String[] strArray = {name,fname,dob,address,phone,email,adhaar,class10,class12,course,branch};
                List <Boolean> fieldIsEmpty = new ArrayList<Boolean>();
               

                int i =0;
                for(; i < strArray.length;i++){
                    if(strArray[i].isEmpty()){
                        flag = false;
                        fieldIsEmpty.add(true);
                    }else{
                        fieldIsEmpty.add(false);
                    }
                }
//                if(i>= strArray.length){
//                flag = true;
//                 }
               
            if(flag){
                studentFrame.dispose();

                try {//Creating mysql query

                String query = "insert into students values('"+name+"','"+fname+"','"+rollno+"',"
                                 +"'"+dob+"','"+address+"','"+phone+"','"+email+"','"+adhaar+"','"
                                 +class10+"','"+class12+"','"+course+"','"+branch+"')";


                Conn connect = new Conn(); //Creating and Registering driver class
                connect.s.executeUpdate(query); //executeUpdate method use for DML commands in sql

                



            } catch (Exception ex) { 
                ex.printStackTrace();
            }
                
            popUpSucessImage(); //This line will only executed when the data is successfully inserted into the table
            }else{
                
//                popUpFailureImage();
            for(int num =0; num<fieldIsEmpty.size();num++){
                if(fieldIsEmpty.get(num) == true){
                    isEmpty(num);
                }else{
                    changeBorderColorToBlack(num);
                }
               
            }
                
            }    
        
        }else if(e.getSource() == cancelButton){
            

            studentFrame.dispose();
            studentbgFrame.dispose();
            if( ShowStudentDetails.isShowStuDetailON == true){
                
                ShowStudentDetails.isShowStuDetailON = false;
                ShowStudentDetails.studentbgFrame.setVisible(true);
                ShowStudentDetails.studentDetailsframe.setVisible(true);
                
            }else{
               
                Dashboard.dashboardFrame.setVisible(true);
                
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
