package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    public static final int DEFAULT_STACK_VALUE = 1;
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
}