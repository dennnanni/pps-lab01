package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    public static final int MIN_PIN_VALUE = 1000;
    public static final int MAX_PIN_VALUE = 9999;
    private boolean locked = false;
    private int pin;

    private boolean isPinValid() {
        return pin >= MIN_PIN_VALUE && pin <= MAX_PIN_VALUE;
    }

    @Override
    public void setPin(int pin) {
        if (!isPinValid()) {
            throw new IllegalStateException();
        }
        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {

    }

    @Override
    public void lock() {
        if (!isPinValid()) {
            throw new IllegalStateException();
        }

        this.locked = true;
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
