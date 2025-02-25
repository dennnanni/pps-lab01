package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int DEFAULT_ELEMENT = 1;

    @Test
    public void isInitiallyEmpty() {
        CircularQueue queue = new CircularQueueImpl();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void addElement() {
        CircularQueue queue = new CircularQueueImpl();
        queue.add(DEFAULT_ELEMENT);
        assertFalse(queue.isEmpty());
    }


}
