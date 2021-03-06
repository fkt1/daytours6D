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

    //private String[] language = {"danish", "english", "german", "icelandic", "spanish"};
    
    private ArrayList<Tours> tour = new ArrayList<Tours>();

    private SQLiteJDBC database;
    
    private Tours data = new Tours();

    public Search(SQLiteJDBC database) {
        this.database = database;
        
    }

    public Search() {

        this.database = new SQLiteJDBC();

    }

    public ArrayList<Tours> getResults(double duration, String type, String difficulty,
            String area, String language, String date){
                
        String searchString = createString(duration, type, difficulty, area, language, date);
        System.out.println(searchString);
        
        ArrayList<Tours> results = new ArrayList<Tours>();

        ResultSet db = database.getData(searchString);
        try {
            while (db.next()) {
                

                data.setId(db.getInt("id"));
                data.setDuration(db.getDouble("duration"));
                data.setType(db.getString("type"));
                data.setDifficulty(db.getString("difficulty"));
                data.setArea(db.getString("area"));
                data.setSeatsTotal(db.getInt("seats_total"));
                data.setSeatsAvailable(db.getInt("seats_available"));
                data.setPickup(db.getBoolean("pickup"));
                data.setHandicap(db.getBoolean("handicap"));
                data.setDate(db.getString("date"));
                data.setPrice(db.getInt("price"));

                Array lang = db.getArray("language");
                //String [] language1 = (String[])lang.getArray();
                //String[] language2 = new String[language1.length];
                //for (int i = 0; i < language1.length; i++) {
                //    language2[i] = language[language1[i]];
                //}
                data.setLanguage((String[])lang.getArray());

                tour.add(data);

                System.out.println( data.getArea() + " " + data.getPrice() + " " + Arrays.toString(data.getLanguage()) );
            }
            System.out.println("Thetta tokst");
        } catch (Exception ex) {
            System.out.println("engar niðurstöður");
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }

    	return tour; 
    }
    
    public void createResults(String values) {
        ArrayList<Tours> results = new ArrayList<Tours>();

            ResultSet db = database.getData("SELECT * FROM Tour");
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
                    data.setPickup(db.getBoolean("pickup"));
                    data.setHandicap(db.getBoolean("handicap"));
                    data.setDate(db.getString("date"));
                    data.setPrice(db.getInt("price"));
                    
                    Array lang = db.getArray("language");
                    //String [] language1 = (String[])lang.getArray();
                    //String[] language2 = new String[language1.length];
                    //for (int i = 0; i < language1.length; i++) {
                    //    language2[i] = language[language1[i]];
                    //}
                    data.setLanguage((String[])lang.getArray());
                    
                    tour.add(data);
                        
                    System.out.println( data.getArea() + " " + data.getPrice() + " " + Arrays.toString(data.getLanguage()) );
                }
                System.out.println("Thetta tokst");
            } catch (Exception ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static String createString(double duration, String type, String difficulty,
            String area, String language, String date){
        String res = "SELECT * FROM TOUR;";
        String res2 = "SELECT * FROM TOUR WHERE";
        // Array for strings for dur, type, diff, lang, area, pUp, hCap, date;
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
        	parts.add(" duration = " + "'" + area + "'");
        }
        if (language.compareTo(("")) != 0) {
        	parts.add(" language = " + "'" + language + "'");
        }
        if (date.compareTo(("")) != 0) {
        	parts.add(" date = " + "'" + date + "'");
        }
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
