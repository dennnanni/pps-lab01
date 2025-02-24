package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    public static final int PIN_LENGTH = 4;
    private boolean locked = false;
    private String pin;

    @Override
    public void setPin(String pin) {
        if (pin.length() != PIN_LENGTH) {
            throw new IllegalStateException();
        }
        this.pin = pin;
    }

    @Override
    public void unlock(String pin) {
        if (this.pin.equals(pin)) {
            this.locked = false;
        }
    }

    @Override
    public void lock() {
        if (this.pin == null) {
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
