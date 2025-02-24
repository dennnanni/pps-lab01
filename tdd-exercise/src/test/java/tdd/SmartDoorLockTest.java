package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    public static final String PIN = "1234";
    public static final String WRONG_PIN = "0000";
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
    public void setWrongPin() {
        assertAll(
                () -> assertThrows(IllegalStateException.class, () -> this.doorLock.setPin("10000")),
                () -> assertThrows(IllegalStateException.class, () -> this.doorLock.setPin("999")),
                () -> assertThrows(IllegalStateException.class, () -> this.doorLock.setPin("123")),
                () -> assertThrows(IllegalStateException.class, () -> this.doorLock.setPin("10"))
        );
    }

    private void setPinAndLock() {
        this.doorLock.setPin(PIN);
        this.doorLock.lock();
    }

    @Test
    public void setPinAndTryToLock() {
        setPinAndLock();
        assertTrue(this.doorLock.isLocked());
    }

    @Test
    public void unlockWithCorrectPin() {
        setPinAndLock();
        this.doorLock.unlock(PIN);
        assertFalse(this.doorLock.isLocked());
    }

    @Test
    public void tryUnlockWithWrongPin() {
        setPinAndLock();
        this.doorLock.unlock(WRONG_PIN);
        assertTrue(this.doorLock.isLocked());
    }

    @Test
    public void checkFailedAttemptsCounterValue() {
        setPinAndLock();
        this.doorLock.unlock(WRONG_PIN);
        assertEquals(1, this.doorLock.getFailedAttempts());
    }

    @Test
    public void checkResetFailedAttemptsAfterSuccessfulUnlock() {
        setPinAndLock();
        this.doorLock.unlock(WRONG_PIN);
        this.doorLock.unlock(PIN);
        assertAll(
                () -> assertEquals(0, this.doorLock.getFailedAttempts()),
                () -> assertFalse(this.doorLock.isLocked())
        );
    }

    @Test
    public void blockAfterTooManyUnsuccessfulAttempts() {
        setPinAndLock();
        for (int i = 0; i < this.doorLock.getMaxAttempts(); i++) {
            this.doorLock.unlock(WRONG_PIN);
        }
        assertTrue(this.doorLock.isBlocked());
    }

}
