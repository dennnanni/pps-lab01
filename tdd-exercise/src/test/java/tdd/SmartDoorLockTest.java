package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    @Test
    public void isInitiallyUnlocked() {
        SmartDoorLock doorLock = new SmartDoorLockImpl();
        assertFalse(doorLock.isLocked());
    }

}
