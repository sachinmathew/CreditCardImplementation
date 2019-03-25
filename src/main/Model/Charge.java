package main.Model;
public class Charge  {
    double amount;
    int day;
    String type;
    double accountBalance;

    public Charge(double amount, int day, String type,double accountBalance) {
        this.amount = amount;
        this.day = day;
        this.type = type;
        this.accountBalance = accountBalance;

    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {

        return accountBalance;
    }

    public double getAmount() {
        return amount;
    }

    public int getDay() {
        return day;
    }

    public String getType() {
        return type;
    }

}
