package Controller;

import Model.Account;
import Model.MainModel;
import View.MainMenu;
import Utility.UpdateAccountDetails;


import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
Main class which controls entire flow
 */
public class MainController {
    public static Logger logger = Logger.getLogger("MyLog");
    public static FileHandler fh;
    public static void main(String[] args) throws IOException {
        fh = new FileHandler("Logfile.log");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
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
                logger.info( "Account created " + newAccount.getCard().getCardNumber());
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
                    logger.info( amountToBeCharged.get(1) + " charged on account " + amountToBeCharged.get(0) );
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
                    logger.info( amountToBeCharged.get(1) + " paid on account " + amountToBeCharged.get(0) );
                }
                displayMenus();
                break;
            case 4:
                int days = MainMenu.displayNumberOfDaysRequired();

                if(days > 0) {
                    for(int i = 1;i <= days;i++){
                        MainModel.setDay(MainModel.getDay() + 1);
                        if(MainModel.getDay()%30 == 0){
                            logger.info( "Interests updated" );
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
