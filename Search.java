import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by thorunn on 09/03/16.
 */
public class Search
{
    private String[] type = {"adventure", "city walk", "horseriding", "hiking",  "sightseeing"};
    private String[] difficulty = {"easy", "medium", "hard"};
    private String[] area = {"Capital region", "east", "north", "south", "west"};
    private String[] language = {"danish", "english", "german", "icelandic", "spanish"};
    
    private ArrayList<Tours> tour = new ArrayList<Tours>();

    private SQLiteJDBC database;

    public Search(SQLiteJDBC database) {
        this.database = database;
    }

    public ArrayList<Tours> getResults(String duration, String type, String difficulty, 
            String area, String language, int date){ 
        
    /*    return tour;
    }   
        
          
    public ArrayList<Tours> getResults(String searchString) {
    */        
        String searchString = createString(duration, type, difficulty, area, language, date);
        
        database.getData(searchString);

    	return tour; 
    }
    
    public void createResults(String values) {
        ArrayList<Tours> results = new ArrayList<Tours>();

            ResultSet db = database.getData("SELECT * FROM users");
            try {
                while (db.next()) {
                    Tours data = new Tours();

                    data.setArea(db.getString("name"));
                    data.setPrice(db.getInt("username"));
                    Array lang = db.getArray("language");
                    data.setLanguage((String[])lang.getArray());
                    //tour.setLanguage(data.getArray("language"));
                    
                    tour.add(data);
                        
                    System.out.println( data.getArea() + " " + data.getPrice() + " " + Arrays.toString(data.getLanguage()) );
                }
                System.out.println("Thetta tokst");
            } catch (Exception ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static String createString(String duration, String type, String difficulty, 
            String area, String language, int date){ 
        String res = "SELECT * FROM TOURS;";
        String res2 = "SELECT * FROM TOURS WHERE";
        // Array for strings for dur, type, diff, lang, area, pUp, hCap, date;
        String[] parts = new String[6];//{durS, typeS, diffS, langS, areaS, pUpS, hCapS, dateS};
        boolean condition = false;
        int conditions = 0;
        
        if (duration != "") {
        	parts[0] = " duration = "+duration;
        	condition = true;
        	conditions++;
        }
        if (type != "") {
        	parts[1] = " type = "+type;
        	condition = true;
        	conditions++;
        }
        if (difficulty != "") {
        	parts[2] = " difficulty = "+difficulty;
        	condition = true;
        	conditions++;
        }
        if (area != "") {
        	parts[3] = " duration = "+area;
        	condition = true;
        	conditions++;
        }
        if (language != "") {
        	parts[4] = " language = "+language;
        	condition = true;
        	conditions++;
        }
        if (date != 0) {
        	parts[5] = " date = "+date;
        	condition = true;
        	conditions++;
        }
        if (condition == false) return res;
        else {
        	for (int i = 0; i<parts.length; i++) {
        		if (parts[i] != null && conditions > 1) {
        			res2 += parts[i] +" AND";
        			conditions--;
        		}
        		else if (parts[i] != null) {
        			res2 += parts[i];
        			conditions--;
        		}
        	}
        	return res2+";";
        }
    }

}
