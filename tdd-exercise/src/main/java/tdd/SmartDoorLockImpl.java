package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    private boolean locked = false;
    private boolean pinSet = false;
    private int pin;

    @Override
    public void setPin(int pin) {
        this.pin = pin;
        pinSet = true;
    }

    @Override
    public void unlock(int pin) {

    }

    @Override
    public void lock() {
        if (!pinSet) {
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
