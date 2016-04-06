/**
 * Created by thorunn on 09/03/16.
 */
public class Search
{
    private String[] type = {"adventure", "city walk", "horseriding", "hiking",  "sightseeing"};
    private String[] difficulty = {"easy", "medium", "hard"};
    private String[] area = {"Capital region", "east", "north", "south", "west"};
    private String[] language = {"danish", "english", "german", "icelandic", "spanish"};
    
	private Tours tour;

    private DummySQLJDBC database;

    public Search(DummySQLJDBC database) {
        this.database = database;
    }

    public Tours getResults() {

        database.getData("SELECT * FROM Tours");

    	return tour; 
    }

}
