package Controller;

import Model.Account;
import Model.MainModel;
import View.MainMenu;
import Utility.UpdateAccountDetails;


import java.util.List;

/*
Main class which controls entire flow
 */
public class MainController {

    public static void main(String[] args) {
        displayMenus();
    }

    public static void displayMenus(){
        int choice = MainMenu.displayMainMenu();
        switch (choice){
            case 1:
                List<Object> details = MainMenu.displayRegistrationDetails();
                String cardNumber = CardRegistrationController.registerCardMember(details);
                Account newAccount = MainModel.getAccountDetails(cardNumber);
                MainMenu.displayAccount(newAccount);
                displayMenus();
                break;
            case 2:
                List<String> amountToBeCharged = MainMenu.displayChargeMenu();
                amountToBeCharged.add("charge");
                int statusCode = MainModel.commitChargeTransaction(amountToBeCharged);
                if(statusCode == -1)
                    MainMenu.displayCardNumberDoNotExist();
                else if(statusCode == -404)
                    MainMenu.displayInsufficentBalanace();
                else{

                    MainMenu.displayTransactionSuccessfull();
                }
                displayMenus();
                break;
            case 3:
                amountToBeCharged = MainMenu.displayPaymentMenu();
                amountToBeCharged.add("Payment");
                statusCode = MainModel.commitPaymentTransaction(amountToBeCharged);
                if(statusCode == -1)
                    MainMenu.displayCardNumberDoNotExist();
                else if(statusCode == -404)
                    MainMenu.displayMoneyCreditBack();
                else{

                    MainMenu.displayTransactionSuccessfull();
                }
                displayMenus();
                break;
            case 4:
                int days = MainMenu.displayNumberOfDaysRequired();

                if(days > 0) {
                    for(int i = 1;i <= days;i++){
                        MainModel.setDay(MainModel.getDay() + 1);
                        if(MainModel.getDay()%30 == 0){
                            for (Account acc: MainModel.accountList) {
                                UpdateAccountDetails.updateDetails(acc);
                            }
                            MainModel.setMonth( MainModel.getMonth() +1 );
                        }
                    }

                }
                else
                    MainMenu.printInvalidInput();
                displayMenus();
                break;

            case 5:
                cardNumber = MainMenu.getCardDetails();
                if( MainModel.getAccountDetails(cardNumber) == null){
                    MainMenu.displayCardNumberDoNotExist();
                    displayMenus();
                }
                else {
                    Account account = MainModel.getAccountDetails(cardNumber);
                    MainMenu.displayAccount(account);
                    displayMenus();
                }
                break;
            case 6:
                System.exit(0);
                break;
            default:
                MainMenu.printInvalidInput();
                displayMenus();

        }

    }
}
