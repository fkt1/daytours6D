import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by thorunn on 03/04/16.
 */
public class ToursTest {

    @Test
    public void testGetPrice_ReturnsCorrectPrice() {
        // Given
        Tours tours = new Tours();
        tours.setPrice(100);

        // When
        int price = tours.getPrice();

        // Then
        assertEquals(100, price);
    }

    @Test
    public void testGetPickup_ReturnsFalseIfNoPickup() {
        // Given
        Tours tours = new Tours();

        // When
        boolean hasPickup = tours.getPickup();

        // Then
        assertFalse(hasPickup);
    }

    @Test
    public void testGetPickup_ReturnsTrueWhenPickup() throws Exception {
        // Given
        Tours tours = new Tours();
        tours.setPickup(true);

        // When
        boolean hasPickup = tours.getPickup();

        // Then
        assertTrue(hasPickup);
    }
}