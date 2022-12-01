
package university.management.system;

import java.sql.*;

/*Steps to Connect with JDBC 
1.Register the driver class
2.Creating connection String
3.Creating Statement
4.Executing the MySQL Queries
5.Closing the connection
*/

public class Conn {   
    Connection c;
    Statement s;
    Conn(){
        try {
            /*1.==========Registering the driver class ======*/
            Class.forName("com.mysql.cj.jdbc.Driver");  
 
            /*2.==========Creating the connection String===*/
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/UniversityManagementSystem",
           "root","Test@123"); 

            //By deafault mysql port is 3306 so we can ignore localhost:3306 part
            //so we can write in this way too:
              /*c= DriverManager.getConnection("jdbc:mysql:///UniversityManagementSystem","root","Test@123");*/
            
            /*3.==========Creating Statement===*/
            
            s= c.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
