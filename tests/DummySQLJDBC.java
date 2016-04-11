package tests;

/**
 * Created by thorunn on 03/04/16.
 */
public class DummySQLJDBC {

    /**
     * Returns the data in string format or null if no data is found for
     * the given command.
     * @param command
     * @return
     */
    // testing123
    public String getData(String command) {
        // dummy
        return "";
    }

    /**
     *
     * @return True if the command successfully deleted stuff
     */
    public boolean delete(String command) {
        return false;
    }
}
