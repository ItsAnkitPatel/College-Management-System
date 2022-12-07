package college.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;




public class ShowTeacherDetails implements ActionListener {
 static boolean isShowTeachDetailsON = false;

 static JFrame teacherDetailsFrame ,teacherbgFrame;
    Choice empNoChoice;
    JTable table ;
    JButton clearButton,searchButton,addButton,updateButton,printButton,cancelButton;

    public ShowTeacherDetails() {
        isShowTeachDetailsON = true;

            /*============Adding Background image first*/
            teacherbgFrame = new JFrame();
            teacherbgFrame.setSize(1920,1080);
            teacherbgFrame.setLocation(0,0);
            teacherbgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/Background2.png"));
            Image img2 = img.getImage().getScaledInstance(1920, 1080,Image.SCALE_SMOOTH);
            ImageIcon img3 = new ImageIcon(img2);

            JLabel addBackgroundImage = new JLabel(img3);
            addBackgroundImage.setBounds(0,0,1920,1080);
            teacherbgFrame.add(addBackgroundImage);
            teacherbgFrame.setUndecorated(true);
            teacherbgFrame.setResizable(false);
            teacherbgFrame.setVisible(true);



        teacherDetailsFrame = new JFrame();
        teacherDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teacherDetailsFrame.setSize(1400,800);
        teacherDetailsFrame.setLocation(300, 100);
        teacherDetailsFrame.getContentPane().setBackground(Color.WHITE);
        teacherDetailsFrame.setLayout(null);
        teacherDetailsFrame.setResizable(false);

                //============Adding Image and making edges round===========================================
                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Database.jpg"));
                Image i2 = i1.getImage().getScaledInstance(550, 345,Image.SCALE_SMOOTH);
                ImageIcon finalImageIcon = new ImageIcon(i2);


                JLabel addImage = new JLabel(finalImageIcon);
                addImage.setBounds(850,445,550,345);
                teacherDetailsFrame.add(addImage);



                    teacherDetailsFrame.setUndecorated(true);
                    teacherDetailsFrame.setShape(new RoundRectangle2D.Double(0, 0, 1400,800, 30, 30)); //This will make the edges rounded



        /*======================Heading Label=======================================*/
        JLabel headingLabel = new JLabel("Search by Employee ID");
        headingLabel.setBounds(20,50,200,20);
        headingLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        teacherDetailsFrame.add(headingLabel);




        /*======================Adding Choice employee bar====================================*/
        empNoChoice = new Choice();
        empNoChoice.setFont(new Font("Times New Roman",Font.BOLD,18));
        empNoChoice.setBounds(250,50,200,25);
        teacherDetailsFrame.add(empNoChoice);


            //Creating Connection and then add all employee number values into empNoChoice bar    
            try {
                Conn connect = new Conn();
                ResultSet rs = connect.s.executeQuery("select * from teachers");//The resultset will store the whole result of the query given quotes
                while(rs.next()){
                    empNoChoice.add(rs.getString("EmpId")); //Adding the employeeId column into Choice bar
                }


            } catch (Exception e) {
                e.printStackTrace();
            }



        /*====================Adding Clear button on the right side of choice bar================================*/   

        clearButton =new JButton("Clear");
        clearButton.setBounds(470,50,100,25);
        clearButton.setFont(new Font("Times New Roman",Font.BOLD,18));

        clearButton.addActionListener(this);

         clearButton.setBackground(Color.WHITE);

         // ADDING CURSOR SYMBOL 
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

         //SETTING BORDER TRANSPARENT
        clearButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        teacherDetailsFrame.add(clearButton);



        /*======================Adding Table ====================================*/
        table = new JTable();
        table.setFillsViewportHeight(true);
        table.setFont(new Font("Times New Roman",Font.BOLD,15));
        table.setEnabled(false);

        tableCreation();


       /*======================Search Button and Image Icon====================================*/
        ImageIcon searchIcon = new ImageIcon(ClassLoader.getSystemResource("icons/SearchButtonImage.png"));
        Image searchImg = searchIcon.getImage().getScaledInstance(180, 70, Image.SCALE_SMOOTH);
        ImageIcon searchFinalImageIcon = new ImageIcon(searchImg);

        searchButton = new JButton(searchFinalImageIcon);
        searchButton.setBounds(80,460,180,70);
        searchButton.setBackground(Color.WHITE);

         // ADDING CURSOR SYMBOL 
        searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

         //SETTING BORDER TRANSPARENT
        searchButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        searchButton.addActionListener(this);
        teacherDetailsFrame.add(searchButton);




         /*======================Update Button and Image Icon====================================*/
        ImageIcon updateIcon = new ImageIcon(ClassLoader.getSystemResource("icons/UpdateButtonImage.png"));
        Image updateImg = updateIcon.getImage().getScaledInstance(190, 70, Image.SCALE_SMOOTH);
        ImageIcon updateFinalImageIcon = new ImageIcon(updateImg);


        updateButton = new JButton(updateFinalImageIcon);
        updateButton.setBounds(310,460,190,70);
        updateButton.setBackground(Color.WHITE);
         // ADDING CURSOR SYMBOL 
        updateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

         //SETTING BORDER TRANSPARENT
        updateButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        updateButton.addActionListener(this);
        teacherDetailsFrame.add(updateButton);




         /*======================Add Button and Image Icon====================================*/

        ImageIcon addIcon = new ImageIcon(ClassLoader.getSystemResource("icons/AddButtonImage.png"));
        Image addImg = addIcon.getImage().getScaledInstance(180, 65, Image.SCALE_SMOOTH);
        ImageIcon addFinalImageIcon = new ImageIcon(addImg);


        addButton = new JButton(addFinalImageIcon);
        addButton.setBounds(80,550,180,65);
        addButton.setBackground(Color.WHITE);
         // ADDING CURSOR SYMBOL 
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

         //SETTING BORDER TRANSPARENT
        addButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        addButton.addActionListener(this);
        teacherDetailsFrame.add(addButton);




         /*======================Print Button and Image Icon ===================================*/
        ImageIcon printIcon = new ImageIcon(ClassLoader.getSystemResource("icons/PrintButtonImage.png"));
        Image printImg = printIcon.getImage().getScaledInstance(180, 65, Image.SCALE_SMOOTH);
        ImageIcon printFinalImageIcon = new ImageIcon(printImg);

        printButton = new JButton(printFinalImageIcon);
        printButton.setBounds(310,550,180,65);
        printButton.setBackground(Color.WHITE);

         // ADDING CURSOR SYMBOL 
        printButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

         //SETTING BORDER TRANSPARENT
        printButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        printButton.addActionListener(this);
        teacherDetailsFrame.add(printButton);



        /*======================Cancel Button and Image Icon====================*/


        ImageIcon cancelIcon = new ImageIcon(ClassLoader.getSystemResource("icons/CancelButtonImage.png"));
        Image cancel = cancelIcon.getImage().getScaledInstance(210, 90, Image.SCALE_SMOOTH);
        ImageIcon cancelFinalImageIcon = new ImageIcon(cancel);

        cancelButton = new JButton(cancelFinalImageIcon);
        cancelButton.setBounds(180,650,200,80);
        cancelButton.setBackground(Color.WHITE);
         // ADDING CURSOR SYMBOL 
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

         //SETTING BORDER TRANSPARENT
        cancelButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        cancelButton.addActionListener(this);

        teacherDetailsFrame.add(cancelButton);
        
/*==============================================THE END===========================================================*/   
        

        teacherDetailsFrame.setVisible(true);
        
    }
     void tableCreation(){
         try {
                Conn connect = new Conn();
                ResultSet rs = connect.s.executeQuery("select * from teachers");//This will store the whole result of the given query in double quotes
                table.setModel(DbUtils.resultSetToTableModel(rs));
                table.setRowHeight(50);
               
                
                JScrollPane jsp = new JScrollPane(table); //This will add a scrollbar into our table
                jsp.setBounds(10,100,1380,350);
                jsp.setBorder(BorderFactory.createEmptyBorder(0,0,0,0)); 
                teacherDetailsFrame.add(jsp);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    
            
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == clearButton){
            
              teacherDetailsFrame.dispose();
              teacherbgFrame.dispose();
              
           new ShowTeacherDetails(); //The only reason we are re launching a new anonymous object because the table is not properly rendering
                                     // which is why we are doing this
        }
        
        
        else if(e.getSource() == searchButton){
             String query = "select * from teachers where EmpId = '"+empNoChoice.getSelectedItem()+"'";
            try {
                
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                table.setRowHeight(50);
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        }
        
        
        else if(e.getSource() == updateButton){
            teacherDetailsFrame.dispose();
            teacherbgFrame.dispose();
            new UpdateTeacher();
            
        }
        
        
        else if(e.getSource() == addButton){
            
            teacherDetailsFrame.setVisible(false);
            teacherbgFrame.setVisible(false);
            
            new AddTeacher();
        }
        
        
        else if(e.getSource() == printButton){
            try {
                table.print();
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        
        else if(e.getSource() == cancelButton){
            
            teacherDetailsFrame.dispose();
            teacherbgFrame.dispose();
            
            Dashboard.dashboardFrame.setVisible(true);
           
        }
    }
    
}
