package main.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Account {
    Card card;
    String accountHolderName;
    double totalOutstandingBalance;
    List<Charge>  charges;
    HashMap<Integer,List<Charge>> map;

    //Constructor
    Account(String name, Card card){
        accountHolderName = name;
        this.card = card;
        totalOutstandingBalance = 0;
        charges = new ArrayList<>();

        map = new HashMap<>();
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    public void setMap(int month, List<Charge> charge) {
        map.put(month,charge);
    }

    public HashMap<Integer, List<Charge>> getMap() {

        return map;
    }

    public List<Charge> getCharges() {
        return charges;
    }

    public void addCharges(Charge charges) {
        this.charges.add(charges);
    }



    //getter and setter functions
    public void setCard(Card card) {
        this.card = card;
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setTotalOutstandingBalance(double totalOutstandingBalance) {
        this.totalOutstandingBalance = totalOutstandingBalance;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getTotalOutstandingBalance() {

        return totalOutstandingBalance;
    }
    public Card getCard() {
        return card;
    }


}
