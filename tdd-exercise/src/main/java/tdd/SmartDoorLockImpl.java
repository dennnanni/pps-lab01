package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    private boolean locked = false;
    private int pin = -1;

    @Override
    public void setPin(int pin) {

    }

    @Override
    public void unlock(int pin) {

    }

    @Override
    public void lock() {
        if (this.pin == -1) {
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
