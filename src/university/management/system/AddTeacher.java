
package university.management.system;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;



public class AddTeacher implements ActionListener,Runnable{

JLabel showMessage1,showMessage2,showMessage3,showMessage4,showMessage5,showMessage6,showMessage7,showMessage8,showMessage9,showMessage10,showMessage11;
    Thread t ;
    JFrame teacherFrame  ;
    JFrame teacherbgFrame;
    
    
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
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dcdob.getDateEditor();
        editor.setEnabled(false);
        editor.setBackground(Color.WHITE);
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
        teacherFrame.add(class10Label);
        
        
        class10TextField = new JTextField();
        class10TextField.setBounds(260,440,100,30);
        class10TextField.setFont(new Font("Times New Roman",Font.PLAIN,24));
        teacherFrame.add(class10TextField);
        
        //Using lambda to create a check on class10TextField so that user can only enter numbers
            class10TextField.addKeyListener(new KeyAdapter() {

                public void keyPressed(KeyEvent ke) {

                    if (((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||ke.getKeyChar() == '.' )&&(class10TextField.getText().length()<5)|| (ke.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                       class10TextField.setEditable(true);

                    } else {
                       class10TextField.setEditable(false);
                    }
                }
            });
        
        
        
        
        
         /*===========Class 12th Label and it's Text field=================*/
        class12Label = new JLabel("Class XII(%)");
        class12Label.setBounds(100,500,150,50);
        class12Label.setFont(new Font("Times New Roman",Font.BOLD,25));
        teacherFrame.add(class12Label);
        
        
        class12TextField = new JTextField();
        class12TextField.setBounds(260,508,100,30);
        class12TextField.setFont(new Font("Times New Roman",Font.PLAIN,25));
        teacherFrame.add(class12TextField);
        
        //Using lambda to create a check on class12TextField so that user can only enter numbers
            class12TextField.addKeyListener(new KeyAdapter() {

                public void keyPressed(KeyEvent ke) {

                    if (((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||ke.getKeyChar() == '.' )&&(class12TextField.getText().length()<5)|| (ke.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                       class12TextField.setEditable(true);

                    } else {
                       class12TextField.setEditable(false);
                    }
                }
            });
        
        
        
        
        
        
        /*===========Qualification Label and it'scombo box=================*/
        qualificationLabel = new JLabel("Qualification");
        qualificationLabel.setBounds(100,580,160,50);
        qualificationLabel.setFont(new Font("Times New Roman",Font.BOLD,26));
        teacherFrame.add(qualificationLabel);
        
        String[] courses = {"","M.Tech","Msc","MBA","MCA","MCom","MA"};
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
        
        
        String branch[] = {"","Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
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
        
      
        /*Creating object of all message lables and making them invisible for the time*/
                
                //Message1 for name field
                showMessage1 = new JLabel("You cannot left this field empty");
                showMessage1.setFont(new Font("serif",Font.PLAIN,12));
                showMessage1.setBounds(nameTextField.getX(),nameTextField.getY()+30,200,20);
                teacherFrame.add(showMessage1);
                showMessage1.setVisible(false);
                 
                 
                //Message2 for fname field
                showMessage2 = new JLabel("You cannot left this field empty");
                showMessage2.setFont(new Font("serif",Font.PLAIN,12));
                showMessage2.setBounds(fatherNameTextField.getX(),fatherNameTextField.getY()+30,200,20);
                teacherFrame.add(showMessage2);
                showMessage2.setVisible(false);
                
                //Message3 for dcdob field
                showMessage3 = new JLabel("You cannot left this field empty");
                showMessage3.setFont(new Font("serif",Font.PLAIN,12));
                showMessage3.setBounds(740,225,200,20);
                teacherFrame.add(showMessage3);
                showMessage3.setVisible(false);
                
                //Message4 for address field
                showMessage4= new JLabel("You cannot left this field empty");
                showMessage4.setFont(new Font("serif",Font.PLAIN,12));
                showMessage4.setBounds(210,415,210,20);
                teacherFrame.add(showMessage4);
                showMessage4.setVisible(false);
                
                //Message5 for phone field
                showMessage5 = new JLabel("You cannot left this field empty");
                showMessage5.setFont(new Font("serif",Font.PLAIN,12));
                showMessage5.setBounds(phoneTextField.getX(),phoneTextField.getY()+30,200,20);
                teacherFrame.add(showMessage5);
                showMessage5.setVisible(false);
                
                //Message6 for email field
                showMessage6 = new JLabel("You cannot left this field empty");
                showMessage6.setFont(new Font("serif",Font.PLAIN,12));
                showMessage6.setBounds(emailTextField.getX(),emailTextField.getY()+30,200,20);
                teacherFrame.add(showMessage6);
                showMessage6.setVisible(false);
        
                //Message7 for adhaar field
                showMessage7 = new JLabel("You cannot left this field empty");
                showMessage7.setFont(new Font("serif",Font.PLAIN,12));
                showMessage7.setBounds(adhaarTextField.getX(),adhaarTextField.getY()+30,200,20);
                teacherFrame.add(showMessage7);
                showMessage7.setVisible(false);
                
                //Message8 for class10 field
                showMessage8 = new JLabel("You cannot left this field empty");
                showMessage8.setFont(new Font("serif",Font.PLAIN,12));
                showMessage8.setBounds(class10TextField.getX(),class10TextField.getY()+30,200,20);
                teacherFrame.add(showMessage8);
                showMessage8.setVisible(false);
                
                //Message9 for class12 field
                showMessage9 = new JLabel("You cannot left this field empty");
                showMessage9.setFont(new Font("serif",Font.PLAIN,12));
                showMessage9.setBounds(class12TextField.getX(),class12TextField.getY()+30,200,20);
                teacherFrame.add(showMessage9);
                showMessage9.setVisible(false);
                
                //Message10 for course field
                showMessage10 = new JLabel("You cannot left this field empty");
                showMessage10.setFont(new Font("serif",Font.PLAIN,12));
                showMessage10.setBounds(qualificationComboBox.getX(),qualificationComboBox.getY()+30,200,20);
                teacherFrame.add(showMessage10);
                showMessage10.setVisible(false);
                
                //Message11 for branch field
                showMessage11 = new JLabel("You cannot left this field empty");
                showMessage11.setFont(new Font("serif",Font.PLAIN,12));
                showMessage11.setBounds(departmentComboBox.getX(),departmentComboBox.getY()+30,200,20);
                teacherFrame.add(showMessage11);
                showMessage11.setVisible(false);
                
        
        teacherFrame.setUndecorated(true);
        teacherFrame.setShape(new RoundRectangle2D.Double(0, 0, 1100, 900, 30, 30)); //This will make the edges rounded
        teacherFrame.setSize(1100,900);
        teacherFrame.setLocation(400,80);
        teacherFrame.setResizable(false);
        
        teacherFrame.setVisible(true);
        
        teacherbgFrame.setVisible(true);
        
    }
    
    
    public static void main(String[] args) {
        new AddTeacher();
    }
    void popUpSucessImage(){
   
        t =new Thread(this);
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
       
       t.start();
        
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
                qualificationComboBox.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                showMessage10.setVisible(true);
                break;
            
            case 10:
                departmentComboBox.setBorder(BorderFactory.createLineBorder(Color.RED,2));
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
                qualificationComboBox.setBorder(BorderFactory.createLineBorder(Color.GRAY));                
                showMessage10.setVisible(false);
                break;
                
            case 10:
                 departmentComboBox.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                 showMessage11.setVisible(false);
                break;
        }
        
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
          
       boolean flag = true;
                String[] strArray = {name,fname,dob,address,phone,email,adhaar,class10,class12,qualification,department};
                java.util.List <Boolean> fieldIsEmpty = new ArrayList<Boolean>();
               

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
            
            try {//Creating mysql query
            
            String query = "insert into teachers values('"+name+"','"+fname+"','"+rollno+"',"
                             + "'"+dob+"','"+address+"','"+phone+"','"+email+"','"+adhaar+"','"
                             +class10+"','"+class12+"','"+qualification+"','"+department+"')";
            
            
            Conn connet = new Conn(); //Creating and Registering driver class
            connet.s.executeUpdate(query); //executeUpdate method use for DML commands in sql
            
            
        } catch (Exception ex) {
            
            
            ex.printStackTrace();
        }
            
         popUpSucessImage(); //This line will only executed when the data is successfully inserted into the table
         
        }else{
                teacherFrame.setVisible(false);
                    for(int num =0; num<fieldIsEmpty.size();num++){
                        if(fieldIsEmpty.get(num) == true){
                            isEmpty(num);
                        }else{
                            changeBorderColorToBlack(num);
                        }
                    }  
                teacherFrame.setVisible(true);

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
            teacherFrame.dispose();
            Thread.sleep(800);
            popupSuccessImageFrame.dispose();   
            teacherbgFrame.dispose();
            new AddTeacher();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

