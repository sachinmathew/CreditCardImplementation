package main.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainModel {
    static  Map<String,Account> accountMap = new HashMap<>();
    public static List<Account> accountList = new ArrayList<>();

    public static int getDay() {
        return day;
    }

    static int day = 1;

    public static int getMonth() {
        return month;
    }

    static int month = 1;
    public static String createAnAccount(List<Object> details){
        Card card = new Card((Integer) details.get(0),(Integer)details.get(1));
        String name = (String) details.get(2);
        Account account = new Account(name,card);
        accountMap.put(card.getCardNumber(),account);
        accountList.add(account);
        return String.valueOf(card.getCardNumber());
    }
    public static Account getAccountDetails(String cardNumber){
        return accountMap.get(cardNumber);
    }

    public static void setDay(int day) {
        MainModel.day = day;
    }

    public static int commitChargeTransaction(List<String> amountToBeCharged) {
        if(accountMap.get(amountToBeCharged.get(0)) ==  null)
            return -1;
        Account account = accountMap.get(amountToBeCharged.get(0));

        if((account.getCard().getCardLimit() - account.getTotalOutstandingBalance()-Double.valueOf(amountToBeCharged.get(1))) < 0)
            return -404;
        Charge charge = new Charge(Double.valueOf(amountToBeCharged.get(1)),MainModel.day,amountToBeCharged.get(2),account.getTotalOutstandingBalance());
        account.addCharges(charge);
        account.setTotalOutstandingBalance( account.getTotalOutstandingBalance() + charge.getAmount() );
        return 1;
    }

    public static int commitPaymentTransaction(List<String> amountToBeCharged) {
        if(accountMap.get(amountToBeCharged.get(0)) ==  null)
            return -1;
        Account account = accountMap.get(amountToBeCharged.get(0));

        if((account.getTotalOutstandingBalance()-Double.valueOf(amountToBeCharged.get(1))) < 0){
            account.setTotalOutstandingBalance(0);
            return -404;
        }

        Charge charge = new Charge(Double.valueOf(amountToBeCharged.get(1)),MainModel.day,amountToBeCharged.get(2),account.getTotalOutstandingBalance());
        account.addCharges(charge);
        account.setTotalOutstandingBalance( account.getTotalOutstandingBalance() - charge.getAmount() );
        return 1;
    }

    public static void setMonth(int month) {
        MainModel.month = month;
    }
}
