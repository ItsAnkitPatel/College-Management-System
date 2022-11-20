
package university.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;
import javax.swing.*;



public class AddTeacher implements ActionListener,Runnable{
    static boolean addTeach = false;
    Thread t;
    JFrame teacherFrame  ;
    JFrame teacherbgFrame;
    static int  threadNumber =0;
    
    JLabel nameLabel,fatherNameLabel,empIDLabel,
            phoneLabel,generatedEmpIDNumber,emailLabel ,adhaarLabel,class10Label,class12Label;
    
    JTextField nameTextField,fatherNameTextField,
                phoneTextField,emailTextField,adhaarTextField,class10TextField,class12TextField;
    
    Random rm = new Random();
    long empIDno = Math.abs((rm.nextLong()%9000L)+1000);  /*rm.nextLong %9000 will give -1 to 1 to ignore negative use Math.abs 
                                                 and we need only 4 digits that's why we are adding 1000*/
    
    JLabel DOB;
    JDateChooser dcdob ;
    
    
    JLabel addressLabel;
    JTextArea addressTextArea;

    
    
    JLabel qualificationLabel;
    JComboBox qualificationComboBox;
    
    JLabel departmentLabel;
    JComboBox departmentComboBox;
    
    JButton submitButton,cancelButton ;
    

    
    
    JFrame popupSuccessImageFrame ;
    JFrame popupFailureImageFrame ;
   
    
    void addTeacherBackground(){
    teacherbgFrame = new JFrame();
        
       /*============Adding Background image first*/
        teacherbgFrame.setSize(1920,1080);
        teacherbgFrame.setLocation(0,0);
        teacherbgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/Background3.png"));
        Image img2 = img.getImage().getScaledInstance(1920, 1080,Image.SCALE_SMOOTH);
        ImageIcon img3 = new ImageIcon(img2);
        
        JLabel addBackgroundImage = new JLabel(img3);
        addBackgroundImage.setBounds(0,0,1920,1080);
        teacherbgFrame.add(addBackgroundImage);
        teacherbgFrame.setUndecorated(true);
        teacherbgFrame.setResizable(false);
        teacherbgFrame.setVisible(true);
}
    public AddTeacher() {
        
        addTeach =true;
       
        
        addTeacherBackground();
        
        teacherFrame = new JFrame() ;
        teacherFrame.getContentPane().setBackground(Color.WHITE);
       
        teacherFrame.setLayout(null);
        teacherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        
//=========================Title of the form====================================

        JLabel title = new JLabel("New Teacher Details");
        title.setBounds(350,20,500,50);
        title.setFont(new Font("Times New Roman",Font.BOLD,35));
        teacherFrame.add(title);
        
        
        
       /*===========Name Label and it's Text field=================*/
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(100,100,100,50);
        nameLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        teacherFrame.add(nameLabel);
        
        
        nameTextField = new JTextField();
        nameTextField.setBounds(200,110,250,30);
        nameTextField.setFont(new Font("Ubuntu Mono",Font.PLAIN,25));
        teacherFrame.add(nameTextField);
        
        
        
        
        /*===========Father name Label and it's Text field=================*/
        fatherNameLabel = new JLabel("Father's Name");
        fatherNameLabel.setBounds(550,100,180,50);
        fatherNameLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        teacherFrame.add(fatherNameLabel);
        
        
        fatherNameTextField = new JTextField();
        fatherNameTextField.setBounds(740,110,250,30);
        fatherNameTextField.setFont(new Font("Ubuntu Mono",Font.PLAIN,25));
        teacherFrame.add(fatherNameTextField);
        
        
        
        
        
        /*===========EmployeeID Label and it's Text field=================*/
        empIDLabel = new JLabel("Employee ID");
        empIDLabel.setBounds(100,180,150,50);
        empIDLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        teacherFrame.add(empIDLabel);
        
        
        generatedEmpIDNumber = new JLabel("101"+empIDno);
        generatedEmpIDNumber.setBounds(280,190,200,30);
        generatedEmpIDNumber.setFont(new Font("Times New Roman",Font.PLAIN,25));
        teacherFrame.add(generatedEmpIDNumber);
        
        
        
        
        
        /*===========Date Of Birth Label and it's Text field=================*/
        DOB = new JLabel("Date of Birth");
        DOB.setBounds(550,180,180,50);
        DOB.setFont(new Font("Times New Roman",Font.BOLD,25));
        teacherFrame.add(DOB);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(740,190,250,30);
        dcdob.setFont(new Font("Times New Roman",Font.PLAIN,20));
        teacherFrame.add(dcdob);
        
        
        
        
        
        /*===========Address Label and it's Text field=================*/
        addressLabel = new JLabel("Address");
        addressLabel.setBounds(100,250,100,50);
        addressLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        teacherFrame.add(addressLabel);
        
       
        
        addressTextArea = new JTextArea();
        addressTextArea.setLineWrap(true); //This will help to wrap the lines so it will not cross the border
        addressTextArea.setWrapStyleWord(true);
        addressTextArea.setFont(new Font("Times New Roman",Font.PLAIN,20));
        
        
        
        
        
        
        //============Adding scroll bar======================
        JScrollPane jsp = new JScrollPane(addressTextArea);
        jsp.setBounds(210,260,300,150);

        
        teacherFrame.add(jsp);
                

        
        
        
        /*===========Phone number Label and it's Text field=================*/
        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(550,250,100,50);
        phoneLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        teacherFrame.add(phoneLabel);
        
        
        phoneTextField = new JTextField();
        phoneTextField.setBounds(740,260,250,30);
        phoneTextField.setFont(new Font("Times New Roman",Font.PLAIN,25));
        teacherFrame.add(phoneTextField);
        
        
        
        
         /*===========EmailID Label and it's Text field=================*/
        emailLabel = new JLabel("EmailID");
        emailLabel.setBounds(550,320,100,50);
        emailLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        teacherFrame.add(emailLabel);
        
        emailTextField = new JTextField();
        emailTextField.setBounds(740,330,250,30);
        emailTextField.setFont(new Font("Times New Roman",Font.PLAIN,25));
        teacherFrame.add(emailTextField);
        
        
        
        
        
         /*===========AdhaarNo. Label and it's Text field=================*/
        adhaarLabel = new JLabel("AdhaarNo.");
        adhaarLabel.setBounds(550,380,130,50);
        adhaarLabel.setFont(new Font("Times New Roman",Font.BOLD,26));
        teacherFrame.add(adhaarLabel);
        
        
        adhaarTextField = new JTextField();
        adhaarTextField.setBounds(740,385,250,30);
        adhaarTextField.setFont(new Font("Times New Roman",Font.PLAIN,24));
        teacherFrame.add(adhaarTextField);
        
        
        
        
         /*===========Class 10th Label and it's Text field=================*/
        class10Label = new JLabel("Class X(%)");
        class10Label.setBounds(100,430,150,50);
        class10Label.setFont(new Font("Times New Roman",Font.BOLD,25));
        teacherFrame.add(class10Label);
        
        
        class10TextField = new JTextField();
        class10TextField.setBounds(260,440,100,30);
        class10TextField.setFont(new Font("Times New Roman",Font.PLAIN,24));
        teacherFrame.add(class10TextField);
        
        
        
        
        
        
         /*===========Class 12th Label and it's Text field=================*/
        class12Label = new JLabel("Class XII(%)");
        class12Label.setBounds(100,500,150,50);
        class12Label.setFont(new Font("Times New Roman",Font.BOLD,25));
        teacherFrame.add(class12Label);
        
        
        class12TextField = new JTextField();
        class12TextField.setBounds(260,508,100,30);
        class12TextField.setFont(new Font("Times New Roman",Font.PLAIN,25));
        teacherFrame.add(class12TextField);
        
        
        
        
        
        
        
        /*===========Qualification Label and it'scombo box=================*/
        qualificationLabel = new JLabel("Qualification");
        qualificationLabel.setBounds(100,580,150,50);
        qualificationLabel.setFont(new Font("Times New Roman",Font.BOLD,26));
        teacherFrame.add(qualificationLabel);
        
        String[] courses = {"M.Tech","Msc","MBA","MCA","MCom","MA"};
        qualificationComboBox = new JComboBox(courses);
        qualificationComboBox.setBounds(260,595,200,25);
        qualificationComboBox.setFont(new Font("Times New Roman",Font.BOLD,20));
        qualificationComboBox.setBackground(Color.WHITE);
        teacherFrame.add(qualificationComboBox);
        
        
        
        
        
        
        /*===========Department Label and it's combo box =================*/
        departmentLabel = new JLabel("Department");
        departmentLabel.setBounds(100,650,150,50);
        departmentLabel.setFont(new Font("Times New Roman",Font.BOLD,26));
        teacherFrame.add(departmentLabel);
        
        
        String branch[] = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
        departmentComboBox = new JComboBox(branch);
        departmentComboBox.setFont(new Font("Times New Roman",Font.BOLD,18));
        departmentComboBox.setBounds(260,664,200,25);
        departmentComboBox.setBackground(Color.WHITE);
        
        teacherFrame.add(departmentComboBox);
        
        
        
        
        
        
        /*=========================Image Icon====================*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/AddDataImage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400,Image.SCALE_SMOOTH);
        ImageIcon finalImageIcon = new ImageIcon(i2);
        

        JLabel addImage = new JLabel(finalImageIcon);
        addImage.setBounds(700,500,400,400);
        teacherFrame.add(addImage);
        
        
        
        
        
        /*=========================Submit Button Image Icon====================*/
        ImageIcon submitIcon = new ImageIcon(ClassLoader.getSystemResource("icons/SubmitButtonImage.png"));
        Image submit = submitIcon.getImage().getScaledInstance(200, 80, Image.SCALE_SMOOTH);
        ImageIcon submitFinalImageIcon = new ImageIcon(submit);
        
 
        
        submitButton=  new JButton(submitFinalImageIcon);
        submitButton.setBounds(465,752,200,80);
        
        

        // ADDING CURSOR SYMBOL 
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //SETTING BORDER TRANSPARENT
        submitButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        submitButton.setBackground(Color.WHITE);
        submitButton.addActionListener(this);
        
        teacherFrame.add(submitButton);
       
        
        /*=========================Cancel Button Image Icon====================*/
        
        
        ImageIcon cancelIcon = new ImageIcon(ClassLoader.getSystemResource("icons/CancelButtonImage.png"));
        Image cancel = cancelIcon.getImage().getScaledInstance(210, 85, Image.SCALE_SMOOTH);
        ImageIcon cancelFinalImageIcon = new ImageIcon(cancel);

        cancelButton=  new JButton(cancelFinalImageIcon);
        cancelButton.setBounds(150,748,210,85);

        

        // ADDING CURSOR SYMBOL 
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //SETTING BORDER TRANSPARENT
        cancelButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        cancelButton.setBackground(Color.WHITE);
        
        cancelButton.addActionListener(this);        
        teacherFrame.add(cancelButton);
        
      
        teacherFrame.setUndecorated(true);
        teacherFrame.setShape(new RoundRectangle2D.Double(0, 0, 1100, 900, 30, 30)); //This will make the edges rounded
        teacherFrame.setSize(1100,900);
        teacherFrame.setLocation(400,80);
        teacherFrame.setResizable(false);
        
        teacherFrame.setVisible(true);
        
        teacherbgFrame.setVisible(true);
        
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
        String rollno = generatedEmpIDNumber.getText();
        String dob =((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
        String address = addressTextArea.getText();
        String phone = phoneTextField.getText();
        String email = emailTextField.getText();
        String adhaar = adhaarTextField.getText();
        String class10 = class10TextField.getText();
        String class12 = class12TextField.getText();
        String qualification  = (String)qualificationComboBox.getSelectedItem();
        String department = (String) departmentComboBox.getSelectedItem();
          
        boolean flag = false;
        String[] strArray = {name,fname,rollno,dob,address,phone,adhaar,class10,class12,qualification,department};
        
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
            
            try {//Creating mysql query
            
            String query = "insert into teachers values('"+name+"','"+fname+"','"+rollno+"',"
                    + "'"+dob+"','"+address+"','"+phone+"','"+email+"','"+adhaar+"','"+class10+"','"+class12+"','"+qualification+"','"+department+"')";
            
            
            Conn connet = new Conn(); //Creating and Registering driver class
            connet.s.executeUpdate(query); //executeUpdate method use for DML commands in sql
            
            
        } catch (Exception ex) {
            
            
            ex.printStackTrace();
        }
            
         popUpSucessImage(); //This line will only executed when the data is successfully inserted into the table
        }else{
            teacherFrame.setVisible(false);
            popUpFailureImage();
        }    
        }else if(e.getSource() == cancelButton){
            
            
            teacherFrame.dispose();
            teacherbgFrame.dispose();

            if(ShowTeacherDetails.showTeachDetails == true){
                
                ShowTeacherDetails.showTeachDetails = false;
                ShowTeacherDetails.teacherbgFrame.setVisible(true);
                ShowTeacherDetails.teacherDetailsFrame.setVisible(true);
                
            }else{
                 Dashboard.dashboardFrame.setVisible(true);
            }
            
        }
        
    }

    @Override
    public void run() {
        try {
            if(threadNumber ==1){//1 is for success 
                teacherFrame.dispose();
            Thread.sleep(800);
            
            popupSuccessImageFrame.dispose();
            threadNumber =0;
            teacherbgFrame.dispose();
            new AddTeacher();
            }else if(threadNumber ==2 ){ // 2 is for failure 
                 
                threadNumber =0;
                Thread.sleep(1500);
                popupFailureImageFrame.dispose();
                
                teacherFrame.setVisible(true);
               
                
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

