package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    public static final int DEFAULT_STACK_VALUE = 1;
    public static final int MAX_VALUE = 5;
    public static final int MIN_VALUE = 1;
    public static final int[] VALUES_END_WITH_MAX = {3, 1, 2, 4, 2, 5};
    public static final int[] VALUES_END_WITH_MIN = {2, 4, 6, 3, 5, 1};
    public static final int[] VALUES = {5, 2, 1, 4, 2, 3, 4};
    MinMaxStack stack;

    @BeforeEach
    public void create() {
        stack = new MinMaxStackImpl();
    }

    @Test
    public void isStackInitiallyEmpty() {
        assertAll(
                () -> assertTrue(stack.isEmpty()),
                () -> assertEquals(0, stack.size())
        );
    }

    @Test
    public void pushValue() {
        stack.push(0);
        assertAll(
                () -> assertFalse(stack.isEmpty()),
                () -> assertEquals(1, stack.size())
        );
    }

    @Test
    public void tryPushingWhenFull() {
        for (int i = 0; i < 100; i++) {
            stack.push(DEFAULT_STACK_VALUE);
        }
        assertThrows(IllegalStateException.class, () -> stack.push(DEFAULT_STACK_VALUE));
    }

    @Test
    public void popValue() {
        stack.push(DEFAULT_STACK_VALUE);
        int value = stack.pop();
        assertAll(
                () -> assertTrue(stack.isEmpty()),
                () -> assertEquals(DEFAULT_STACK_VALUE, value)
        );
    }

    @Test
    public void popValueFromEmptyStack() {
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    public void peekValue() {
        stack.push(DEFAULT_STACK_VALUE);
        int value = stack.peek();
        assertAll(
                () -> assertFalse(stack.isEmpty()),
                () -> assertEquals(DEFAULT_STACK_VALUE, value)
        );
    }

    @Test
    public void peekValueFromEmptyStack() {
        assertThrows(IllegalStateException.class, () -> stack.peek());
    }

    @Test
    public void getMaxFromEmptyStack() {
        assertThrows(IllegalStateException.class, () -> stack.getMax());
    }

    private void fillWithValues(int[] values) {
        for (int value : values) {
            stack.push(value);
        }
    }

    @Test
    public void getMax() {
        fillWithValues(VALUES);
        assertEquals(MAX_VALUE, stack.getMax());
    }

    @Test
    public void getMaxAfterMaxIsPopped() {
        int secondMaxValue = 4;
        fillWithValues(VALUES_END_WITH_MAX);
        stack.pop();
        assertEquals(secondMaxValue, stack.getMax());
    }

    @Test
    public void getMinFromEmptyStack() {
        assertThrows(IllegalStateException.class, () -> stack.getMin());
    }

    @Test
    public void getMin() {
        fillWithValues(VALUES);
        assertEquals(MIN_VALUE, stack.getMin());
    }

    @Test
    public void getMinAfterMinIsPopped() {
        int secondMinValue = 2;
        fillWithValues(VALUES_END_WITH_MIN);
        stack.pop();
        assertEquals(secondMinValue, stack.getMin());
    }
}