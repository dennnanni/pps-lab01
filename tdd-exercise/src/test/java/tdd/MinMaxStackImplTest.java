package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    @Test
    public void isStackInitiallyEmpty() {
        MinMaxStack stack = new MinMaxStackImpl();
        assertAll(
                () -> assertTrue(stack.isEmpty()),
                () -> assertEquals(0, stack.size())
        );
    }

    @Test
    public void pushValue() {
        MinMaxStack stack = new MinMaxStackImpl();
        stack.push(0);
        assertAll(
                () -> assertFalse(stack.isEmpty()),
                () -> assertEquals(1, stack.size())
        );
    }

}