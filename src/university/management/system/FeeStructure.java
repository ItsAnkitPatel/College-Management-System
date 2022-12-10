package college.management.system;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class FeeStructure implements ActionListener{
    JFrame feeStructureFrame ,feeStructurebgFrame ;
    JLabel title;
    JTable table;
    JButton exitButton;
    public FeeStructure() {
    
    
        /*===============Adding Background image first===============================================*/
                    feeStructurebgFrame = new JFrame();
                    feeStructurebgFrame.setSize(1920,1080);
                    feeStructurebgFrame.setLocation(0,0);
                    feeStructurebgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    feeStructurebgFrame.setLayout(null);

                    ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/Background3.png"));
                    Image img2 = img.getImage().getScaledInstance(1920, 1080,Image.SCALE_SMOOTH);
                    ImageIcon img3 = new ImageIcon(img2);

                    JLabel addBackgroundImage = new JLabel(img3);
                    addBackgroundImage.setBounds(0,0,1920,1080);
                    feeStructurebgFrame.add(addBackgroundImage);
                    feeStructurebgFrame.setUndecorated(true);
                    feeStructurebgFrame.setResizable(false);
                    feeStructurebgFrame.setVisible(true);

        
           
        feeStructureFrame = new JFrame();
        feeStructureFrame.setSize(1100,600);
        feeStructureFrame.setLocation(450,100);
        feeStructureFrame.getContentPane().setBackground(Color.WHITE);
        feeStructureFrame.setLayout(null);
        feeStructureFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        feeStructureFrame.setUndecorated(true);
        feeStructureFrame.setShape(new RoundRectangle2D.Double(0, 0, 1100, 600, 30, 30)); //This will make the edges rounded
        feeStructureFrame.setResizable(false);
            
/*==============================================Title of the form=======================================================*/

        title = new JLabel("Fee Structure");
        title.setBounds(430,10,500,50);
        title.setFont(new Font("Times New Roman",Font.BOLD,35));
        feeStructureFrame.add(title);
                 
    
/*===============================================TABLE===============================================================*/
        table = new JTable();
        table.setFillsViewportHeight(true);
        table.setFont(new Font("Times New Roman",Font.BOLD,15));
        
            JScrollPane jsp = new JScrollPane(table); //This will add a scrollbar into our table
            jsp.setBounds(5,100,1095,350);
            jsp.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            feeStructureFrame.add(jsp);
        
        try {
                Conn connect = new Conn();
                ResultSet rs = connect.s.executeQuery("select * from fee");//This will store the whole result of the given query in double quotes
                table.setModel(DbUtils.resultSetToTableModel(rs));
                table.setRowHeight(40);

            } catch (Exception e) {
               
            }

        
/*=================================ExitImage + Text + Button=====================================================*/
        
                ImageIcon exitImage= new ImageIcon(ClassLoader.getSystemResource("icons/ExitImage2.png"));
                Image exit = exitImage.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
                ImageIcon exit2 = new ImageIcon(exit);



                //=========Exit Text======================
                JLabel exitText = new JLabel("EXIT");
                exitText.setBounds(90,540,100,30);
                feeStructureFrame.add(exitText);


                //=========Exit Button==================== 

                exitButton = new JButton(exit2);
                exitButton.setBounds(50,480,80,70);
                exitButton.setBackground(new Color(0,0,0,0));
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;

                //SETTING BORDER TRANSPARENT
                exitButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                
                // ADDING CURSOR SYMBOL
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                exitButton.addActionListener(this);
                feeStructureFrame.add(exitButton);

        

/*===============================================THE END===========================================================*/                 
        feeStructureFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() == exitButton){
        feeStructureFrame.dispose();
        feeStructurebgFrame.dispose();
        Dashboard.dashboardFrame.setVisible(true);
    }
    
    }
    
}
