package college.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class FeeStructure {
    JFrame feeStructureFrame ,feeStructurebgFrame ;
    JLabel title;
    JTable table;
    public FeeStructure() {
    
    
        /*============Adding Background image first*/
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
        feeStructureFrame.setSize(1100,700);
        feeStructureFrame.setLocation(450,100);
        feeStructureFrame.getContentPane().setBackground(Color.WHITE);
        feeStructureFrame.setLayout(null);
        feeStructureFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        feeStructureFrame.setUndecorated(true);
        feeStructureFrame.setShape(new RoundRectangle2D.Double(0, 0, 1100, 700, 30, 30)); //This will make the edges rounded
        feeStructureFrame.setResizable(false);
            
/*==============================================Title of the form=======================================================*/

        title = new JLabel("Fee Structure");
        title.setBounds(350,10,500,50);
        title.setFont(new Font("Times New Roman",Font.BOLD,35));
        feeStructureFrame.add(title);
                 
    
/*===============================================TABLE===============================================================*/
        table = new JTable();
        table.setFillsViewportHeight(true);
        table.setFont(new Font("Times New Roman",Font.BOLD,15));
        
            JScrollPane jsp = new JScrollPane(table); //This will add a scrollbar into our table
            jsp.setBounds(5,150,1095,350);
            jsp.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            feeStructureFrame.add(jsp);
        
        try {
                Conn connect = new Conn();
                ResultSet rs = connect.s.executeQuery("select * from fee");//This will store the whole result of the given query in double quotes
                table.setModel(DbUtils.resultSetToTableModel(rs));
                table.setRowHeight(40);

            } catch (Exception e) {
               
            }
            
   
        
        
        
        
//        
//                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/FeeIcon.jpg"));
//                Image i2 = i1.getImage().getScaledInstance(450, 300,Image.SCALE_SMOOTH);
//                ImageIcon finalImageIcon = new ImageIcon(i2);
//
//
//                JLabel addImage = new JLabel(finalImageIcon);
//                addImage.setBounds(400,500,450,300);
//                feeStructureFrame.add(addImage);


        
        
        
        
        
/*===============================================THE END===========================================================*/                 
        feeStructureFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new FeeStructure();
    }
    
}
