import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by thorunn on 03/04/16.
 */
@RunWith(MockitoJUnitRunner.class) // Makes sure we can use @Mock
public class SearchTest {

    private Search search;

    @Mock
    private DummySQLJDBC mockDatabase;

    @Before
    public void setUp() throws Exception {

        // Use the mock database as input to the search class.
        search = new Search(mockDatabase);
    }

    @Test
    public void testGetResults_CallsDatabaseWithCorrectCommand() { // This test will pass
        // Make database return dummy data for the input given
        when(mockDatabase.getData("SELECT * FROM Tours")).thenReturn("DATA");

        search.getResults(); // Method that will call the mocked object

        // Verify that we called getData with the correct string input
        verify(mockDatabase).getData("SELECT * FROM Tours");
    }

    @Test
    public void testGetResults_CallsDatabaseWithCorrectCommand_FailingTest() { // This test will fail, just for demo
        // Make database return dummy data for the input given
        when(mockDatabase.getData("SELECT * FROM Tours")).thenReturn("DATA");

        search.getResults(); // Method that will call the mocked object

        // Verify that we called getData with the correct string input
        verify(mockDatabase).getData("SELECT * FROM Tour"); // s is missing from "Tours" string
    }

}