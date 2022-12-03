
package university.management.system;

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
import javax.swing.JOptionPane;

public class ExaminationDetails implements ActionListener{
    

    JFrame marksDetailsBgFrame,marksDetailsFrame;
    JButton searchButton,cancelButton;
    JLabel title,rollNoLabel;
    JTextField rollTextField;
    JTable table;
    
    public ExaminationDetails()  {
        /*============Adding Background image first=================*/
                    marksDetailsBgFrame = new JFrame();
                    marksDetailsBgFrame.setSize(1920,1080);
                    marksDetailsBgFrame.setLocation(0,0);
                    marksDetailsBgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    marksDetailsBgFrame.setLayout(null);

                    ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/Background2.png"));
                    Image img2 = img.getImage().getScaledInstance(1920, 1080,Image.SCALE_SMOOTH);
                    ImageIcon img3 = new ImageIcon(img2);

                    JLabel addBackgroundImage = new JLabel(img3);
                    addBackgroundImage.setBounds(0,0,1920,1080);
                    marksDetailsBgFrame.add(addBackgroundImage);
                    marksDetailsBgFrame.setUndecorated(true);
                    marksDetailsBgFrame.setResizable(false);
                    marksDetailsBgFrame.setVisible(true);
        
                    
                    
        marksDetailsFrame = new JFrame();
        marksDetailsFrame.setSize(1400,800);
        marksDetailsFrame.setLocation(300, 100);
        marksDetailsFrame.getContentPane().setBackground(Color.WHITE);
        marksDetailsFrame.setLayout(null);
        marksDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //=========================Title of the form====================================

        title = new JLabel("Check Result");
        title.setBounds(350,10,500,50);
        title.setFont(new Font("Times New Roman",Font.BOLD,35));
        marksDetailsFrame.add(title);
        
        
        
        /*=========================Roll no. lable=============================*/
        rollNoLabel = new JLabel("Enter your rollno");
        rollNoLabel.setBounds(50,100,250,30);
        rollNoLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
        marksDetailsFrame.add(rollNoLabel);
        
        
        
            /*========================Roll no. TextField==========================*/        
            rollTextField = new JTextField();
            rollTextField.setBounds(250,100,200,30);
            rollTextField.setFont(new Font("Times New Roman",Font.BOLD,25));
            marksDetailsFrame.add(rollTextField);


   
        /*======================Search Button and Image Icon====================================*/
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

            
        
        
        //=========================TABLE====================================
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
        
        
        /*=========================Cancel Button Image Icon====================*/
        ImageIcon cancelIcon = new ImageIcon(ClassLoader.getSystemResource("icons/CancelButtonImage.png"));
        Image cancel = cancelIcon.getImage().getScaledInstance(210, 85, Image.SCALE_SMOOTH);
        ImageIcon cancelFinalImageIcon = new ImageIcon(cancel);

        cancelButton=  new JButton(cancelFinalImageIcon);
        cancelButton.setBounds(100,600,185,60);
        cancelButton.setBackground(Color.WHITE);
        
        // ADDING CURSOR SYMBOL 
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //SETTING BORDER TRANSPARENT
        cancelButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        cancelButton.addActionListener(this);
        marksDetailsFrame.add(cancelButton);
        
        
        marksDetailsFrame.setUndecorated(true);
        marksDetailsFrame.setShape(new RoundRectangle2D.Double(0, 0, 1400,800,30, 30)); //This will make the edges rounded
        marksDetailsFrame.setResizable(false);
        
        marksDetailsFrame.setVisible(true);


    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == searchButton){
            marksDetailsFrame.dispose();
            marksDetailsBgFrame.dispose();
            new ShowMarks(rollTextField.getText());
        }
        
        else if(ae.getSource() == cancelButton){
         marksDetailsFrame.dispose();
         marksDetailsBgFrame.dispose();
         Dashboard.dashboardFrame.setVisible(true);
     }   
        
    }
    
    
}
