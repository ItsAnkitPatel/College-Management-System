
package college.management.system;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;


public class ExaminationDetails implements ActionListener{
    

    JFrame marksDetailsFrame;
    JButton searchButton,exitButton;
    JLabel title,rollNoLabel;
    JTextField rollTextField;
    JTable table;
    
    public ExaminationDetails()  {
       
                    
        marksDetailsFrame = new JFrame();
        marksDetailsFrame.setSize(1400,800);
        marksDetailsFrame.setLocation(300, 100);
        marksDetailsFrame.getContentPane().setBackground(Color.WHITE);
        marksDetailsFrame.setLayout(null);
        marksDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marksDetailsFrame.setUndecorated(true);
        marksDetailsFrame.setShape(new RoundRectangle2D.Double(0, 0, 1400,650,30, 30)); //This will make the edges rounded
        marksDetailsFrame.setResizable(false);

/*===========================================Title of the form =========================================================*/

        title = new JLabel("Check Result");
        title.setBounds(550,10,500,50);
        title.setFont(new Font("Times New Roman",Font.BOLD,35));
        marksDetailsFrame.add(title);
        
        
        
/*==========================================Roll no. lable==============================================================*/
        rollNoLabel = new JLabel("Enter your rollno");
        rollNoLabel.setBounds(50,100,250,30);
        rollNoLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        marksDetailsFrame.add(rollNoLabel);
        
        
        
/*=========================================Roll no. TextField===========================================================*/        
            rollTextField = new JTextField();
            rollTextField.setBounds(250,100,200,30);
            rollTextField.setFont(new Font("Times New Roman",Font.BOLD,25));
            marksDetailsFrame.add(rollTextField);


   
/*=======================================Search Button and Image Icon===================================================*/

        ImageIcon searchIcon = new ImageIcon(ClassLoader.getSystemResource("icons/searchIcon.png"));
        Image searchImg = searchIcon.getImage().getScaledInstance(38, 33,Image.SCALE_SMOOTH);
        ImageIcon searchFinalImageIcon = new ImageIcon(searchImg);

        searchButton = new JButton(searchFinalImageIcon);
        searchButton.setBounds(460,98,38,33);
        searchButton.setBackground(Color.WHITE);

         // ADDING CURSOR SYMBOL 
        searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

         //SETTING BORDER TRANSPARENT
        searchButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        searchButton.addActionListener(this);
        marksDetailsFrame.add(searchButton);

            
        
        
/*===============================================TABLE===============================================================*/
        table = new JTable();
        table.setFillsViewportHeight(true);
        table.setFont(new Font("Times New Roman",Font.BOLD,15));
        
            JScrollPane jsp = new JScrollPane(table); //This will add a scrollbar into our table
            jsp.setBounds(10,150,1380,350);
            jsp.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            marksDetailsFrame.add(jsp);
        
        try {
                Conn connect = new Conn();
                ResultSet rs = connect.s.executeQuery("select * from students");//This will store the whole result of the given query in double quotes
                table.setModel(DbUtils.resultSetToTableModel(rs));
                table.setRowHeight(50);

            } catch (Exception e) {
                
            }
        
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                rollTextField.setText(table.getModel().getValueAt(row,2).toString());
            }
          
        });
        
/*=================================ExitImage + Text + Button=====================================================*/
        
                ImageIcon exitImage= new ImageIcon(ClassLoader.getSystemResource("icons/ExitImage2.png"));
                Image exit = exitImage.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
                ImageIcon exit2 = new ImageIcon(exit);



                //=========Exit Text======================
                JLabel exitText = new JLabel("EXIT");
                exitText.setBounds(100,600,100,30);
                marksDetailsFrame.add(exitText);


                //=========Exit Button==================== 

                exitButton = new JButton(exit2);
                exitButton.setBounds(50,540,80,70);
                exitButton.setBackground(new Color(0,0,0,0));
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;

                //SETTING BORDER TRANSPARENT
                exitButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                
                // ADDING CURSOR SYMBOL
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                exitButton.addActionListener(this);
                marksDetailsFrame.add(exitButton);

        
/*==============================================THE END===========================================================*/

        marksDetailsFrame.setVisible(true);


    }
  

    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == searchButton){
            marksDetailsFrame.dispose();
            new ShowMarks(rollTextField.getText());

        }
        
        else if(ae.getSource() == exitButton){// If Exit button hit we will enable the dashboard frame
         marksDetailsFrame.dispose();
         Dashboard.dashboardFrame.setVisible(true);
     }   
        
    }
    
    
}
