import java.util.AbstractMap;
import java.util.Map;

public class Account {
    private String accountNumber;
    private String password;
    private double balance;

    private final String ACCOUNT_PASSWORD = "7439";

    public Account(String accountNumber, String password) {
        
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = 0.0;
    }

    private boolean isAccountCorrect(String accountNumber) {
        if (accountNumber.length() < 11) {
            return false;
        }
        return true;
    }

    public Map.Entry<String, Boolean> login() {
        if (!this.isAccountCorrect(accountNumber)) {
            return new AbstractMap.SimpleEntry<>("Account number is incorrect", false);
        }
        if (!password.equals(ACCOUNT_PASSWORD)) {
            return new AbstractMap.SimpleEntry<>("Password is incorrect", false);
        }
        return new AbstractMap.SimpleEntry<>("Login successful", true);
    }

    public double getBalance() {
        return balance;
    }

    public String deposit(double depositAmount) {
        balance += depositAmount;
        return "Deposit successful";
    }

    public String withdraw(double withdrawAmount) {
        if (withdrawAmount > balance) {
            return "Insufficient funds";
        }
        balance -= withdrawAmount;
        return "Withdraw successful";
    }
}
