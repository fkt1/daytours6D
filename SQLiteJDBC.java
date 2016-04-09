//package database_console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class SQLiteJDBC {
	
    public ResultSet getData(String searchString) {
    //public static void main(String [] args ) {
        
        ResultSet rs; 
        
        try {
            String host = "jdbc:postgresql://localhost:5432/userdata";
            String username = "postgres";
            String password = "nufc90";

            Connection con = DriverManager.getConnection(host, username, password);
            Statement stmt = con.createStatement();
            
            String SQL = searchString;
            
            rs = stmt.executeQuery( SQL );
            /*
            while (rs.next()) {
            
                String name = rs.getString("name");
                String uName = rs.getString("username");
                String pWord = rs.getString("password");
                        
                System.out.println( name + " " + uName + " " + pWord );
            }
            //System.out.println("Þetta tókst");
            //System.out.println(rs);
            */
            

        }
        catch (SQLException err) {
            rs = null;
            System.out.println(err.getMessage());
        }
        
        return rs;
    }
    
}
