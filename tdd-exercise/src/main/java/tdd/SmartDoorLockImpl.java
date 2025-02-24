package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    public static final int MAX_UNSUCCESSFUL_ATTEMPTS = 5;
    public static final int PIN_LENGTH = 4;
    private boolean locked = false;
    private String pin;
    private int failedAttempts;

    @Override
    public void setPin(String pin) {
        if (pin.length() != PIN_LENGTH) {
            throw new IllegalStateException();
        }
        this.pin = pin;
    }

    @Override
    public void unlock(String pin) {
        if (!this.isBlocked() && this.pin.equals(pin)) {
            this.locked = false;
            this.failedAttempts = 0;
        } else {
            this.failedAttempts += 1;
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
        return this.failedAttempts >= MAX_UNSUCCESSFUL_ATTEMPTS;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_UNSUCCESSFUL_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {

    }
}
