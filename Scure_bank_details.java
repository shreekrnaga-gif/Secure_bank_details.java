```java
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class BankAccount {

    private String accountNumber;
    private String holderName;
    private String pin;
    private BigDecimal balance;

    private ArrayList<String> transactions;

    public BankAccount(String accountNumber, String holderName,
                       String pin, BigDecimal balance) {

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.pin = pin;
        this.balance = balance;

        transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public boolean authenticate(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) > 0) {

            balance = balance.add(amount);

            transactions.add("Deposited: Rs. " + amount);

            System.out.println("Deposit successful!");
        }
        else {
            System.out.println("Invalid amount!");
        }
    }

    public boolean withdraw(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Invalid amount!");
            return false;
        }

        if (balance.compareTo(amount) >= 0) {

            balance = balance.subtract(amount);

            transactions.add("Withdrawn: Rs. " + amount);

            System.out.println("Withdrawal successful!");

            return true;
        }

        System.out.println("Insufficient balance!");
        return false;
    }

    public
