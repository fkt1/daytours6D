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

    private DummySQLJDBC database;

    public Search(DummySQLJDBC database) {
        this.database = database;
    }

    public ArrayList<Tours> getResults(String searchString) {

        database.getData(searhString);

    	return tour; 
    }
    
    public void createResults(String values) {
        ArrayList<Tours> results = new ArrayList<Tours>();

            //ResultSet
            String db = database.getData("SELECT * FROM Tours");
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
            } catch (SQLException ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}
