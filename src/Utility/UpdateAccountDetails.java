package Utility;

import Model.Account;
import Model.Charge;
import Model.MainModel;

import java.util.ArrayList;
import java.util.List;
/*
Cla0ss which cleans up transactions and updates interests and account balance at every 30 days
 */
public class UpdateAccountDetails {
    static double curr = 0;
    public static void updateDetails(Account account){
        List<Charge> chargesList = account.getCharges();
        double apr = account.getCard().getApr();
        double temp = 0;
        int day = 0;
        boolean flag = true;
        double currInterest = 0;
        if(chargesList.size() < 1){
            account.setTotalOutstandingBalance(account.getTotalOutstandingBalance() + (account.getTotalOutstandingBalance()*(apr/100)/365) * 30);
            return;
        }
        for (Charge charge:chargesList) {
            if(charge.getType() == "charge"){
                flag = true;

                if(curr != 0){
                    currInterest += ((curr) * ((apr/100))/365) *(charge.getDay()- day) ;
                }
                temp = ((curr + charge.getAmount()) * ((apr/100))/365);
                day = charge.getDay();

            }
            else{
                flag = false;
                temp *= (charge.getDay() - day + 1);
                currInterest +=temp;
                curr = charge.getAccountBalance()-charge.getAmount();
                day = charge.getDay();

            }

        }
        if(flag){
            if(day == 1)
                temp = temp * (MainModel.getDay() - day +1);
            else
                temp = temp * (MainModel.getDay() - day);
            currInterest += temp;
        }
        else{
            temp = (curr *(apr/100))/365*(MainModel.getDay() - day);
            currInterest += temp;
        }
        account.setTotalOutstandingBalance( account.getTotalOutstandingBalance() + currInterest );
        account.setCharges( new ArrayList<>());

    }
}
