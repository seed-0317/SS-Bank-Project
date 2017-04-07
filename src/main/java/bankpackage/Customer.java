package bankpackage;

/**
 * Created by yst865 on 4/6/17.
 */
public class Customer {

    // getters and setters

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // instance variables

    public Customer(String account, String name, double balance) {
        this.account = account;
        this.name = name;
        this.balance = balance;
    }

    public Customer() {
    }

    private String account, name;
    private double balance;

    // methods

    public void changeBalanceW(double withdraw) {
            balance -= withdraw;

    }

    public void changeBalanceD(double deposit) {
            balance += deposit;
            System.out.println("Your new balance is: "+balance);
        }

    }


