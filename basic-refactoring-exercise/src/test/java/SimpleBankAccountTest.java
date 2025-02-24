import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    public static final int DEFAULT_DEPOSIT_AMOUNT = 100;
    public static final int DEFAULT_WITHDRAW_AMOUNT = 70;
    public static final int NEW_DEPOSIT_AMOUNT = 50;
    public static final int EXPECTED_AMOUNT = 30;
    public static final int INITIAL_BALANCE = 0;
    public static final int WITHDRAW_FEE = 1;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEFAULT_DEPOSIT_AMOUNT);
        assertEquals(DEFAULT_DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEFAULT_DEPOSIT_AMOUNT);
        bankAccount.deposit(2, NEW_DEPOSIT_AMOUNT);
        assertEquals(DEFAULT_DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEFAULT_DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), DEFAULT_WITHDRAW_AMOUNT);
        assertEquals(EXPECTED_AMOUNT - WITHDRAW_FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEFAULT_DEPOSIT_AMOUNT);
        bankAccount.withdraw(2, DEFAULT_WITHDRAW_AMOUNT);
        assertEquals(DEFAULT_DEPOSIT_AMOUNT, bankAccount.getBalance());
    }
}
