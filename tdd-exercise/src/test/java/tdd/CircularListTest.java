package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void checkCircularity() {
        CircularQueue queue = new CircularQueueImpl();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        assertDoesNotThrow(() -> queue.add(DEFAULT_ELEMENT));
    }
}
