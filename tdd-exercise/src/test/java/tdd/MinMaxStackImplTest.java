package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

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


}