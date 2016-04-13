package daytours.Model;

//package database_console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLiteJDBC {
	
    public ResultSet getData(String searchString) {

        ResultSet rs; 
        
        try {
            
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:daytours.db");
            
            Statement stmt = con.createStatement();
            
            rs = stmt.executeQuery( searchString );
        }
        
        catch (SQLException err) {
            rs = null;
            System.out.println(err.getMessage());
        } catch (ClassNotFoundException ex) {
            rs = null;
            Logger.getLogger(SQLiteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    public void changeData(String changeString) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:daytours.db");
            
            Statement stmt = con.createStatement();
            
            stmt.executeUpdate( changeString );
        }
        
        catch (SQLException err) {
            System.out.println(err.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLiteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
