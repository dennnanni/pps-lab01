package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    public static final int PIN = 0000;
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
        this.doorLock.setPin(PIN);
        this.doorLock.lock();
        assertTrue(this.doorLock.isLocked());
    }

    @Test
    public void setWrongPin() {
        assertAll(
                () -> assertThrows(IllegalStateException.class, () -> this.doorLock.setPin(10000)),
                () -> assertThrows(IllegalStateException.class, () -> this.doorLock.setPin(999)),
                () -> assertThrows(IllegalStateException.class, () -> this.doorLock.setPin(123)),
                () -> assertThrows(IllegalStateException.class, () -> this.doorLock.setPin(10))
        );
    }

}
