package daytours.Controller;

import daytours.Model.SQLiteJDBC;
import daytours.Model.Tours;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by thorunn on 09/03/16.
 */
public class Search {
    
    private ArrayList<Tours> tour;

    private SQLiteJDBC database;

    public Search(SQLiteJDBC database) {
        this.database = database;
        
    }

    public Search() {

        this.database = new SQLiteJDBC();
        this.tour = new ArrayList<Tours>();
    }
       
    public ArrayList<Tours> getResults(double duration, String type, String difficulty,
            String area, int minPrice, int maxPrice, String language, boolean pickup, boolean handicap,
            String date, int availableTickets) {
                
       String searchString = createString(duration, type, difficulty, area, minPrice, 
                maxPrice, language, pickup, handicap, date, availableTickets);
        
        ArrayList<Tours> results = new ArrayList<Tours>();

        ResultSet db = database.getData(searchString);
       
        try {
            while (db.next()) {
                Tours data = new Tours();

                data.setId(db.getInt("id"));
                data.setDuration(db.getDouble("duration"));
                data.setType(db.getString("type"));
                data.setDifficulty(db.getString("difficulty"));
                data.setArea(db.getString("area"));
                data.setSeatsTotal(db.getInt("seats_total"));
                data.setSeatsAvailable(db.getInt("seats_available"));
                data.setPickup(Boolean.parseBoolean(db.getString("pickup")));
                data.setHandicap(Boolean.parseBoolean(db.getString("handicap")));
                data.setDate(db.getString("date"));
                data.setPrice(db.getInt("price"));
                String languageString = db.getString("language");
                String[] languageArray = languageString.split(",");
                data.setLanguage(languageArray);
                tour.add(data);
            }
        } catch (Exception ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }

    	return tour; 
    }
    
    //duration, type, difficulty, area, price, language, pickup, handicap, date, availableTickets
    private String createString(double duration, String type, String difficulty,
            String area, int minPrice, int maxPrice, String language, boolean pickup, boolean handicap, 
            String date, int availableTickets) {
        
        String res = "SELECT * FROM TOUR;";
        String res2 = "SELECT * FROM TOUR WHERE";
        
        ArrayList<String> parts = new ArrayList<>();
        
        if (duration != 0.0) {
            parts.add(" duration = " + duration);
        }
        if (type.compareTo(("")) != 0) {
            parts.add(" type = " + "'" + type + "'");
        }
        if (difficulty.compareTo(("")) != 0) {
            parts.add(" difficulty = " + "'" + difficulty + "'");
        }
        if (area.compareTo(("")) != 0) {
            parts.add(" area = " + "'" + area + "'");
        }
        if (minPrice > 0) {
            if (minPrice >= maxPrice) {
                parts.add(" price >= " + minPrice);
            }
            else parts.add(" price BETWEEN " + minPrice + " AND " + maxPrice);
        }
        else if (maxPrice > 0) {
            parts.add(" price <= " + maxPrice);
        }
        if (language.compareTo(("")) != 0) {
        	parts.add(" language Like " + "'%" + language + "%'");
        }
        if (date.compareTo(("")) != 0) {
        	parts.add(" date = " + "'" + date + "'");
        }
        if (availableTickets != 0) {
            parts.add(" seats_available >= " + availableTickets);
        }
        if (handicap == true) parts.add(" handicap = 'TRUE'");
        
        if (pickup == true) parts.add(" pickup = 'TRUE'");
        
        if (parts.isEmpty()) return res;
        else {
            for (String condition : parts) {
                res2 += condition + " AND";
            }
            res2 = res2.substring(0, res2.length() - 4);
            return res2 + ";";
        }
    }
    
}
