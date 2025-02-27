package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int BIGGER_THAN_SIZE = 11;
    private static final int LOWER_THAN_SIZE = 5;
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

    private void enqueueIncrementalValuesUpTo(int max) {
        for (int i = 0; i < max; i++) {
            queue.enqueue(i);
        }
    }

    @Test
    public void checkCircularity() {
        enqueueIncrementalValuesUpTo(CircularQueueImpl.SIZE);
        assertDoesNotThrow(() -> queue.enqueue(DEFAULT_ELEMENT));
    }

    @Test
    public void tryRemoveElement() {
        queue.enqueue(DEFAULT_ELEMENT);
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void checkDequeueWithMultipleValuesEnqueued() {
        enqueueIncrementalValuesUpTo(LOWER_THAN_SIZE);
        assertEquals(0, queue.dequeue());
    }

    @Test
    public void checkRemoveOldestOne() {
        enqueueIncrementalValuesUpTo(BIGGER_THAN_SIZE);
        assertEquals(1, queue.dequeue());
    }

    @Test
    public void cannotRemoveMoreElements() {
        queue.enqueue(DEFAULT_ELEMENT);
        queue.dequeue();
        assertThrows(IllegalStateException.class, () -> queue.dequeue());
    }

    @Test
    public void isSizeTheMaxElementsCount() {
        enqueueIncrementalValuesUpTo(BIGGER_THAN_SIZE);
        assertEquals(CircularQueueImpl.SIZE, queue.getElementsCount());
    }

    @Test
    public void checkIfQueueIsFull() {
        enqueueIncrementalValuesUpTo(BIGGER_THAN_SIZE);
        assertTrue(queue.isFull());
    }
}
