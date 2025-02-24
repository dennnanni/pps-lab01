package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {


    private SmartDoorLock doorLock;

    @BeforeEach
    public void create() {
        this.doorLock = new SmartDoorLockImpl();
    }

    @Test
    public void isInitiallyUnlocked() {
        assertFalse(doorLock.isLocked());
    }

    @Test
    public void canBeLockedWithoutPinSet() {
        assertThrows(IllegalStateException.class, () -> this.doorLock.lock());
    }

    @Test
    public void setPinAndTryToLock() {
        this.doorLock.setPin(0000);
        this.doorLock.lock();
        assertTrue(this.doorLock.isLocked());
    }

}
