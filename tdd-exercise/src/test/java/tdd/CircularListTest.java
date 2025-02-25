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
        queue.enqueue(DEFAULT_ELEMENT);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void checkCircularity() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        assertDoesNotThrow(() -> queue.enqueue(DEFAULT_ELEMENT));
    }

    @Test
    public void removeElement() {
        queue.enqueue(DEFAULT_ELEMENT);
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void checkPopWithMultipleValuesEnqueued() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        assertEquals(0, queue.dequeue());
    }

}
