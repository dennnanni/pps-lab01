package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4})
    public void checkFailedAttemptsCounterValue(int attempts) {
        setPinAndLock();
        for (int i = 0; i < attempts; i++) {
            this.doorLock.unlock(WRONG_PIN);
        }
        assertEquals(attempts, this.doorLock.getFailedAttempts());
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

    private void block() {
        for (int i = 0; i < this.doorLock.getMaxAttempts(); i++) {
            this.doorLock.unlock(WRONG_PIN);
        }
    }

    @Test
    public void blockAfterTooManyUnsuccessfulAttempts() {
        setPinAndLock();
        block();
        assertTrue(this.doorLock.isBlocked());
    }

    @Test
    public void tryUnlockAfterBlock() {
        setPinAndLock();
        block();
        this.doorLock.unlock(PIN);
        assertTrue(this.doorLock.isLocked());
    }

    @Test
    public void resetToInitialState() {
        setPinAndLock();
        block();
        this.doorLock.reset();
        assertAll(
                () -> assertFalse(this.doorLock.isLocked()),
                () -> assertEquals(0, this.doorLock.getFailedAttempts()),
                () -> assertFalse(this.doorLock.isBlocked()),
                () -> assertThrows(IllegalStateException.class, () -> this.doorLock.lock())
        );
    }

}
