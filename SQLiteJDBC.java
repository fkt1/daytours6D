//package database_console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class SQLiteJDBC {
	
    public ResultSet getData(String searchString) {

        ResultSet rs; 
        
        try {
            //String host = "C:/Users/EiríkurAtli/Documents/NetBeansProjects/daytours6D/daytours_database";
            String host = "jdbc:postgresql://localhost:5432/daytours_database";
            String username = "postgres";
            String password = "nufc90";
            
            Connection con = DriverManager.getConnection(host, username, password);
            Statement stmt = con.createStatement();
            
            String SQL = searchString;
            
            rs = stmt.executeQuery( SQL );
        }
        
        catch (SQLException err) {
            rs = null;
            System.out.println(err.getMessage());
        }
        
        return rs;
    }
    
    public void changeData(String changeString) {
        try {
            //String host = "C:/Users/EiríkurAtli/Documents/NetBeansProjects/daytours6D/daytours_database";
            String host = "jdbc:postgresql://localhost:5432/daytours_database";
            String username = "postgres";
            String password = "nufc90";
            
            Connection con = DriverManager.getConnection(host, username, password);
            Statement stmt = con.createStatement();
            
            
            String SQL = changeString;
            
            stmt.executeQuery( SQL );
        }
        
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        
    }
    
}
