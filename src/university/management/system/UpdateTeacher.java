
package college.management.system;


import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class UpdateTeacher implements ActionListener,Runnable{
JLabel showMessage1,showMessage2,showMessage3,showMessage4,showMessage5,showMessage6,showMessage7,showMessage8,showMessage9,showMessage10,showMessage11;

    Thread t;
    JFrame updateTeacherFrame ;
    JFrame updateTeacherbgFrame ;
    

    
    JLabel title ,headingLabel;
    Choice empNoChoice;
    JLabel nameLabel,fatherNameLabel,rollNumberLabel, showEmpNo,
            phoneLabel,emailLabel ,adhaarLabel,class10Label,class12Label;
    
    JTextField nameTextField,fatherNameTextField,
                phoneTextField,emailTextField,adhaarTextField,class10TextField,class12TextField;
    
   
    JLabel DOB;
    JDateChooser dcdob ;
    
    
    JLabel addressLabel;
    JTextArea addressTextArea;
    JScrollPane jsp;
    
    JLabel qualificationLabel;
    JComboBox qualificationComboBox;
    
    
    JLabel departmentLabel;
    JComboBox departmentComboBox;
    
    JButton searchButton,updateButton,cancelButton ;
    

    JFrame popupSuccessImageFrame ;
   
   
    


  
    
    public UpdateTeacher() {
      
                    /*============Adding Background image first================================*/
                    updateTeacherbgFrame = new JFrame();
                    updateTeacherbgFrame.setSize(1920,1080);
                    updateTeacherbgFrame.setLocation(0,0);
                    updateTeacherbgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    updateTeacherbgFrame.setLayout(null);

                    ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/Background1.png"));
                    Image img2 = img.getImage().getScaledInstance(1920, 1080,Image.SCALE_SMOOTH);
                    ImageIcon img3 = new ImageIcon(img2);

                    JLabel addBackgroundImage = new JLabel(img3);
                    addBackgroundImage.setBounds(0,0,1920,1080);
                    updateTeacherbgFrame.add(addBackgroundImage);
                    updateTeacherbgFrame.setUndecorated(true);
                    updateTeacherbgFrame.setResizable(false);
                    updateTeacherbgFrame.setVisible(true);

      
        updateTeacherFrame = new JFrame();
        updateTeacherFrame.setSize(1100,900);
        updateTeacherFrame.setLocation(400,80);
        updateTeacherFrame.getContentPane().setBackground(Color.WHITE);
        updateTeacherFrame.setLayout(null);
        updateTeacherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        updateTeacherFrame.setUndecorated(true);
        updateTeacherFrame.setShape(new RoundRectangle2D.Double(0, 0, 1100, 900, 30, 30)); //This will make the edges rounded
        updateTeacherFrame.setResizable(false);
        
        
/*==============================================Title of the form=======================================================*/

        title = new JLabel("Update Teacher Details");
        title.setBounds(350,10,500,50);
        title.setFont(new Font("Times New Roman",Font.BOLD,35));
        updateTeacherFrame.add(title);
        
/*================================================Heading Label==========================================================*/
        headingLabel = new JLabel("Select Employee Number");
        headingLabel.setBounds(20,70,270,25);
        headingLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        updateTeacherFrame.add(headingLabel);




/*============================================Adding Choice rollnumber bar===============================================*/
        empNoChoice = new Choice();
        empNoChoice.setBounds(300,70,210,25);
        empNoChoice.setFont(new Font("Times New Roman",Font.BOLD,20));
        updateTeacherFrame.add(empNoChoice);


            //Creating Connection and then addButton all roll number values into empNoChoice bar    
            try {
                Conn connect = new Conn();
                ResultSet rs = connect.s.executeQuery("select * from teachers");//The resultset will store the whole result of the query given quotes
                while(rs.next()){
                    empNoChoice.add(rs.getString("EmpId")); //Adding the roolno column into Choice bar
                }


            } catch (Exception e) {
                e.printStackTrace();
            }



        
/*===========================================Search Button and Image Icon===================================================*/
        ImageIcon searchIcon = new ImageIcon(ClassLoader.getSystemResource("icons/searchIcon.png"));
        Image searchImg = searchIcon.getImage().getScaledInstance(35, 30,Image.SCALE_SMOOTH);
        ImageIcon searchFinalImageIcon = new ImageIcon(searchImg);

        searchButton = new JButton(searchFinalImageIcon);
        searchButton.setBounds(520,68,35,30);
        searchButton.setBackground(Color.WHITE);

         // ADDING CURSOR SYMBOL 
        searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

         //SETTING BORDER TRANSPARENT
        searchButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        searchButton.addActionListener(this);
        updateTeacherFrame.add(searchButton);

            
            
            
/*=================================Name Label and it's Text field===============================================*/
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(100,140,100,50);
        nameLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        updateTeacherFrame.add(nameLabel);
        
        
        nameTextField = new JTextField();
        nameTextField.setBounds(200,150,250,30);
        nameTextField.setFont(new Font("Ubuntu Mono",Font.PLAIN,25));
        updateTeacherFrame.add(nameTextField);
        
        
        
        
/*=================================Father name Label and it's Text field==============================================*/
        fatherNameLabel = new JLabel("Father's Name");
        fatherNameLabel.setBounds(550,140,180,50);
        fatherNameLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        updateTeacherFrame.add(fatherNameLabel);
        
        
        fatherNameTextField = new JTextField();
        fatherNameTextField.setBounds(740,150,250,30);
        fatherNameTextField.setFont(new Font("Ubuntu Mono",Font.PLAIN,25));
        updateTeacherFrame.add(fatherNameTextField);
        
        
        
        
/*========================================Rollno Label and it's Text field=====================================*/
        rollNumberLabel = new JLabel("Emp ID.");
        rollNumberLabel.setBounds(100,200,100,50);
        rollNumberLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        updateTeacherFrame.add(rollNumberLabel);
        
        showEmpNo = new JLabel();
        showEmpNo.setBounds(210,210,200,30);
        showEmpNo.setFont(new Font("Times New Roman",Font.PLAIN,25));
        updateTeacherFrame.add(showEmpNo);
        
        
/*===================================Date Of Birth Label and it's Text field==============================================*/
        DOB = new JLabel("Date of Birth");
        DOB.setBounds(550,200,180,50);
        DOB.setFont(new Font("Times New Roman",Font.BOLD,25));
        updateTeacherFrame.add(DOB);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(740,210,250,30);
        dcdob.setFont(new Font("Times New Roman",Font.PLAIN,20));
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dcdob.getDateEditor();
        editor.setEnabled(false);
        editor.setBackground(Color.WHITE);
        updateTeacherFrame.add(dcdob);
        
        

        
/*===================================Address Label and it's Text field====================================================*/
        addressLabel = new JLabel("Address");
        addressLabel.setBounds(100,270,100,50);
        addressLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        updateTeacherFrame.add(addressLabel);
        
       
        
        addressTextArea = new JTextArea();
        addressTextArea.setLineWrap(true); //This will help to wrap the lines so it will not cross the border
        addressTextArea.setWrapStyleWord(true);
        addressTextArea.setFont(new Font("Times New Roman",Font.PLAIN,20));
        
        
            //============Adding scroll bar===================
            jsp = new JScrollPane(addressTextArea);
            jsp.setBounds(210,280,300,150);

        
        updateTeacherFrame.add(jsp);
                

        
   
/*=====================================Phone number Label and it's Text field=============================================*/
        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(550,270,100,50);
        phoneLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        updateTeacherFrame.add(phoneLabel);
        
        
        phoneTextField = new JTextField();
        phoneTextField.setBounds(740,280,250,30);
        phoneTextField.setFont(new Font("Times New Roman",Font.PLAIN,25));
        updateTeacherFrame.add(phoneTextField);
        
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
        
        
        
/*=======================================EmailID Label and it's Text field===========================================*/
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(550,340,100,50);
        emailLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        updateTeacherFrame.add(emailLabel);
        
        emailTextField = new JTextField();
        emailTextField.setBounds(740,350,250,30);
        emailTextField.setFont(new Font("Times New Roman",Font.PLAIN,25));
        updateTeacherFrame.add(emailTextField);
        

        
        
/*========================================AdhaarNo. Label and it's Text field=============================================*/
        adhaarLabel = new JLabel("AdhaarNo.");
        adhaarLabel.setBounds(550,400,130,50);
        adhaarLabel.setFont(new Font("Times New Roman",Font.BOLD,26));
        updateTeacherFrame.add(adhaarLabel);
        
        
        adhaarTextField = new JTextField();
        adhaarTextField.setBounds(740,415,250,30);
        adhaarTextField.setFont(new Font("Times New Roman",Font.PLAIN,24));
        updateTeacherFrame.add(adhaarTextField);
        
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
        
      
/*================================Class 10th Label and it's Text field====================================================*/
        class10Label = new JLabel("Class X(%)");
        class10Label.setBounds(100,450,150,50);
        class10Label.setFont(new Font("Times New Roman",Font.BOLD,25));
        updateTeacherFrame.add(class10Label);
        
        
        class10TextField = new JTextField();
        class10TextField.setBounds(260,460,100,30);
        class10TextField.setFont(new Font("Times New Roman",Font.PLAIN,24));
        updateTeacherFrame.add(class10TextField);
        
        
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
        

        
/*==========================================Class 12th Label and it's Text field==========================================*/
        class12Label = new JLabel("Class XII(%)");
        class12Label.setBounds(100,520,150,50);
        class12Label.setFont(new Font("Times New Roman",Font.BOLD,25));
        updateTeacherFrame.add(class12Label);
        
        
        class12TextField = new JTextField();
        class12TextField.setBounds(260,528,100,30);
        class12TextField.setFont(new Font("Times New Roman",Font.PLAIN,25));
        updateTeacherFrame.add(class12TextField);
        
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
        
        

/*====================================Qualification Label and it'scombo box===============================================*/
        qualificationLabel = new JLabel("Qualification");
        qualificationLabel.setBounds(100,600,160,50);
        qualificationLabel.setFont(new Font("Times New Roman",Font.BOLD,26));
        updateTeacherFrame.add(qualificationLabel);
        
        String[] courses = {"","M.Tech","Msc","MBA","MCA","MCom","MA"};
        qualificationComboBox = new JComboBox(courses);
        qualificationComboBox.setBounds(270,615,200,25);
        qualificationComboBox.setFont(new Font("Times New Roman",Font.BOLD,20));
        qualificationComboBox.setBackground(Color.WHITE);
        updateTeacherFrame.add(qualificationComboBox);
        
        
        
/*============================Department Label and it's combo box =========================================================*/
        departmentLabel = new JLabel("Department");
        departmentLabel.setBounds(100,670,160,50);
        departmentLabel.setFont(new Font("Times New Roman",Font.BOLD,26));
        updateTeacherFrame.add(departmentLabel);
        
        
        String branch[] = {"","Electronics", "Mechanical", "Civil", "IT","Computer Science"};
        departmentComboBox = new JComboBox(branch);
        departmentComboBox.setFont(new Font("Times New Roman",Font.BOLD,18));
        departmentComboBox.setBounds(270,684,200,25);
        departmentComboBox.setBackground(Color.WHITE);
        
        updateTeacherFrame.add(departmentComboBox);
        
        
       
        
/*===================================================Image Icon=====================================================*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/AddDataImage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400,Image.SCALE_SMOOTH);
        ImageIcon finalImageIcon = new ImageIcon(i2);
        

        JLabel addImage = new JLabel(finalImageIcon);
        addImage.setBounds(700,520,400,400);
        updateTeacherFrame.add(addImage);
        
        
        
/*============================================Submit Button Image Icon============================================*/
        ImageIcon submitIcon = new ImageIcon(ClassLoader.getSystemResource("icons/updateButton.png"));
        Image submit = submitIcon.getImage().getScaledInstance(200, 80, Image.SCALE_SMOOTH);
        ImageIcon submitFinalImageIcon = new ImageIcon(submit);
        
        
        
        updateButton=  new JButton(submitFinalImageIcon);
        updateButton.setBounds(465,770,190,60);
        updateTeacherFrame.add(updateButton);

        // ADDING CURSOR SYMBOL 
        updateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //SETTING BORDER TRANSPARENT
        updateButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        updateButton.setBackground(Color.WHITE);
        updateButton.addActionListener(this);
        

  
/*=====================================Cancel Button Image Icon==================================================*/
        
        
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
        updateTeacherFrame.add(cancelButton);
        
        
/*==================Creating object of all message lables and making them invisible for the time============================*/
                
                //Message1 for name field
                showMessage1 = new JLabel("You cannot left this field empty");
                showMessage1.setFont(new Font("serif",Font.PLAIN,12));
                showMessage1.setBounds(nameTextField.getX(),nameTextField.getY()+30,200,20);
                updateTeacherFrame.add(showMessage1);
                showMessage1.setVisible(false);
                 
                 
                //Message2 for fname field
                showMessage2 = new JLabel("You cannot left this field empty");
                showMessage2.setFont(new Font("serif",Font.PLAIN,12));
                showMessage2.setBounds(fatherNameTextField.getX(),fatherNameTextField.getY()+30,200,20);
                updateTeacherFrame.add(showMessage2);
                showMessage2.setVisible(false);
                
                //Message3 for dcdob field
                showMessage3 = new JLabel("You cannot left this field empty");
                showMessage3.setFont(new Font("serif",Font.PLAIN,12));
                showMessage3.setBounds(740,240,200,20);
                updateTeacherFrame.add(showMessage3);
                showMessage3.setVisible(false);
                
                //Message4 for address field
                showMessage4= new JLabel("You cannot left this field empty");
                showMessage4.setFont(new Font("serif",Font.PLAIN,12));
                showMessage4.setBounds(210,430,200,20);
                updateTeacherFrame.add(showMessage4);
                showMessage4.setVisible(false);
                
                //Message5 for phone field
                showMessage5 = new JLabel("You cannot left this field empty");
                showMessage5.setFont(new Font("serif",Font.PLAIN,12));
                showMessage5.setBounds(phoneTextField.getX(),phoneTextField.getY()+30,200,20);
                updateTeacherFrame.add(showMessage5);
                showMessage5.setVisible(false);
                
                //Message6 for email field
                showMessage6 = new JLabel("You cannot left this field empty");
                showMessage6.setFont(new Font("serif",Font.PLAIN,12));
                showMessage6.setBounds(emailTextField.getX(),emailTextField.getY()+30,200,20);
                updateTeacherFrame.add(showMessage6);
                showMessage6.setVisible(false);
        
                //Message7 for adhaar field
                showMessage7 = new JLabel("You cannot left this field empty");
                showMessage7.setFont(new Font("serif",Font.PLAIN,12));
                showMessage7.setBounds(adhaarTextField.getX(),adhaarTextField.getY()+30,200,20);
                updateTeacherFrame.add(showMessage7);
                showMessage7.setVisible(false);
                
                //Message8 for class10 field
                showMessage8 = new JLabel("You cannot left this field empty");
                showMessage8.setFont(new Font("serif",Font.PLAIN,12));
                showMessage8.setBounds(class10TextField.getX(),class10TextField.getY()+30,200,20);
                updateTeacherFrame.add(showMessage8);
                showMessage8.setVisible(false);
                
                //Message9 for class12 field
                showMessage9 = new JLabel("You cannot left this field empty");
                showMessage9.setFont(new Font("serif",Font.PLAIN,12));
                showMessage9.setBounds(class12TextField.getX(),class12TextField.getY()+30,200,20);
                updateTeacherFrame.add(showMessage9);
                showMessage9.setVisible(false);
                
                //Message10 for qualification field
                showMessage10 = new JLabel("You cannot left this field empty");
                showMessage10.setFont(new Font("serif",Font.PLAIN,12));
                showMessage10.setBounds(qualificationComboBox.getX(),qualificationComboBox.getY()+30,200,20);
                updateTeacherFrame.add(showMessage10);
                showMessage10.setVisible(false);
                
                //Message11 for department field
                showMessage11 = new JLabel("You cannot left this field empty");
                showMessage11.setFont(new Font("serif",Font.PLAIN,12));
                showMessage11.setBounds(departmentComboBox.getX(),departmentComboBox.getY()+30,200,20);
                updateTeacherFrame.add(showMessage11);
                showMessage11.setVisible(false);
                
/*===============================================THE END===========================================================*/                                 
        
        updateTeacherFrame.setVisible(true);
    }
    

 /*This will only run when all the validations are checked and all the fields are filled correctly 
   and sql query is successfully executed */    
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
        t.start();
        
    }
    
    
/*This method will add red border to the empty fields left by the user and 
  visible the message below of the empty field*/
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
                jsp.setBorder(BorderFactory.createLineBorder(Color.RED,2));
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
    
/*This method will set all the labels colors black and set labels of all messages to invisible 
  which was first changed by isEmpty method.
    
  This method will executed when we hit the update submit button , 
  the only reason we are doing this because we don't want to keep showing
  the red color even though the user filled the empty field*/
   
    void changeBorderColorToBlack(int num){
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
              jsp.setBorder(BorderFactory.createLineBorder(Color.GRAY));
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
/*When we will hit the search button icon this method will execute .
  This method will fetch all the data on the basis of Employee ID . */   
    void showData(){
        String query = "select * from teachers where EmpId = '"+empNoChoice.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    nameTextField.setText(rs.getString("name"));
                    fatherNameTextField.setText(rs.getString("fname"));
                    showEmpNo.setText(rs.getString("EmpId"));
                    dcdob.setDate(new SimpleDateFormat("dd-MMM-yyyy")
                                        .parse(rs.getString("dob")));
                    
                    addressTextArea.setText(rs.getString("address"));
                    phoneTextField.setText((rs.getString("phone")));
                    emailTextField.setText((rs.getString("email")));
                    adhaarTextField.setText((rs.getString("adhaar")));
                    class10TextField.setText((rs.getString("class_10")));
                    class12TextField.setText((rs.getString("class_12")));
                    qualificationComboBox.setSelectedItem(rs.getString("Qualification"));
                    departmentComboBox.setSelectedItem(rs.getString("Department"));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton){
            showData();
        }

        else if(e.getSource() == updateButton){
            /*Here we are adding a validation if all the field are filled or not*/
                String name = nameTextField.getText();
                String fname = fatherNameTextField.getText();
                String empNo = showEmpNo.getText();
                String dob =((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
                String address = addressTextArea.getText();
                String phone = phoneTextField.getText();
                String email = emailTextField.getText();
                String adhaar = adhaarTextField.getText();
                String class10 = class10TextField.getText();
                String class12 = class12TextField.getText();
                String qualificationString  = (String)qualificationComboBox.getSelectedItem();
                String departmentString = (String) departmentComboBox.getSelectedItem();

                boolean flag = true;
                String[] strArray = {name,fname,dob,address,phone,email,adhaar,class10,class12,qualificationString,departmentString};
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


            if(flag){
                updateTeacherFrame.dispose();

                try {//Creating mysql query

                String query = "update teachers set name ='"+name+"',fname ='"+fname+"'"
                                +",dob='"+dob+"'"+",address='"+address+"',phone='"+phone+"'"
                                +",email='"+email+"',adhaar='"+adhaar+"'"+",class_10='"+class10+"'"
                                +",class_12='"+class12+"'"+",qualification='"+qualificationString+"',department='"+departmentString+"'"
                                +" where EmpId='"+empNo+"'"; 
                
                Conn connect = new Conn(); //Creating and Registering driver class
                connect.s.executeUpdate(query); //executeUpdate method use for DML commands in sql


            } catch (Exception ex) { 
                ex.printStackTrace();
            }
                
            popUpSucessImage(); //This line will only executed when the data is successfully inserted into the table
            }else{  
                updateTeacherFrame.setVisible(false);
                    for(int num =0; num<fieldIsEmpty.size();num++){
                        if(fieldIsEmpty.get(num) == true){
                            isEmpty(num);
                        }else{
                            changeBorderColorToBlack(num);
                        }  
                    }    
                updateTeacherFrame.setVisible(true);
            }
        }
        else if(e.getSource() == cancelButton){
            
            updateTeacherFrame.dispose();
            updateTeacherbgFrame.dispose();
           if( ShowTeacherDetails.isShowTeachDetailsON == true){
                
                ShowTeacherDetails.isShowTeachDetailsON = false;
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
                updateTeacherFrame.dispose();
                Thread.sleep(800);
                popupSuccessImageFrame.dispose();
                updateTeacherbgFrame.dispose();
                new UpdateTeacher();
                
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
