package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    @Test
    public void isStackInitiallyEmpty() {
        MinMaxStack stack = new MinMaxStackImpl();
        assertTrue(stack.isEmpty());
    }
}