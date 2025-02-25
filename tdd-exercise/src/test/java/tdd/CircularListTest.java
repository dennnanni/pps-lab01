package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int DEFAULT_ELEMENT = 1;
    CircularQueue queue;

    @BeforeEach
    public void create() {
        queue = new CircularQueueImpl();
    }

    @Test
    public void isInitiallyEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void addElement() {
        queue.add(DEFAULT_ELEMENT);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void checkCircularity() {
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        assertDoesNotThrow(() -> queue.add(DEFAULT_ELEMENT));
    }

    @Test
    public void removeElement() {
        queue.add(DEFAULT_ELEMENT);
        queue.pop();
        assertTrue(queue.isEmpty());
    }
}
