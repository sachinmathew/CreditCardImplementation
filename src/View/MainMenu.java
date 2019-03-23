package View;

import Model.Account;
import Model.MainModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    class to display Menus and response messages
 */
public class MainMenu {
    static Scanner sc = new Scanner(System.in);
    public static int displayMainMenu(){
        int choice = 0;
        System.out.println( "Enter a valid choice" );
        System.out.println( "Day "+ MainModel.getDay() );
        System.out.println("*********Main Menu*********");
        System.out.println("1.Create an Account");
        System.out.println("2.Add charges");
        System.out.println("3.Add payments");
        System.out.println("4.Jump n number of days");
        System.out.println("5.Get Account Details");
        System.out.println("6.Exit");
        System.out.print("Enter your Choice: ");
        choice = sc.nextInt();
        return choice;
    }
    public static ArrayList<Object> displayRegistrationDetails(){
        ArrayList<Object> details = new ArrayList<>();
        System.out.println( "Enter following details" );
        int accountLimit = 0, APR = 0;
        while(!(accountLimit > 0)){
            System.out.println("Enter Account Limit");
            accountLimit = sc.nextInt();
        }
        while(!(APR > 0)){
            System.out.println("Enter APR");
            APR = sc.nextInt();
        }
        details.add(accountLimit);
        details.add(APR);
        System.out.println("Enter Customer Name");
        details.add(sc.next());
        return details;
    }
    public static ArrayList<Integer> paymentDetails(){
        ArrayList<Integer> details = new ArrayList<>();
        System.out.println( "Enter following  details" );
        int amount = 0;
        int accountNumber = 0;
        while(amount > 0){
            System.out.println("Enter Amount paid");
            amount = sc.nextInt();
        }
        System.out.println("Card Number");
        accountNumber= sc.nextInt();
        details.add(accountNumber);
        details.add(amount);
        return details;
    }
    static ArrayList<Integer> chargeDetails(){
        ArrayList<Integer> details = new ArrayList<>();
        System.out.println( "Enter following  details" );
        int amount = 0;
        int accountNumber = 0;
        while(amount > 0){
            System.out.println("Enter Amount to be charged");
            amount = sc.nextInt();
        }
        System.out.println("Card Number");
        accountNumber= sc.nextInt();
        details.add(accountNumber);
        details.add(amount);
        return details;
    }
    static int jumpNdays(){
        System.out.println("Enter number of days to jump must be number > 0");
        int days = -1;
        while (days < 0){
            days = sc.nextInt();
        }
        return days;
    }
    public static String getCardDetails(){
        System.out.println("Enter  CardNumber");
        return sc.next();
    }
    static public void printInvalidInput(){
        System.out.println("Invalid!!!");
    }

    public static void displayAccount(Account newAccount) {
        System.out.println("*********Account Details************");
        System.out.println("Account Holder Name: " +newAccount.getAccountHolderName());
        System.out.println("Card Number: " +newAccount.getCard().getCardNumber());
        System.out.println("Card CVV: " +newAccount.getCard().getCvv());
        System.out.println("Card Limit: " +newAccount.getCard().getCardLimit());
        System.out.println("Card APR: " +newAccount.getCard().getApr());
        System.out.println("Total Outstanding Balance: " +newAccount.getTotalOutstandingBalance());
        System.out.println("*************************************");
    }

    public static List<String> displayChargeMenu() {
        List<String> list = new ArrayList<>();
        System.out.println("----------------------------------");
        System.out.println("Enter CardNumber");
        list.add(sc.next());
        System.out.println("Enter amount");
        list.add(sc.next());
        return list;
    }

    public static void displayCardNumberDoNotExist() {
        System.out.println("Card Number you entered do not exist. Returning back to Main Menu");
    }

    public static void displayTransactionSuccessfull() {
        System.out.println("Transaction success.");
    }

    public static void displayInsufficentBalanace() {
        System.out.println("Failed. Insufficient balance");
    }

    public static List<String> displayPaymentMenu() {
        List<String> list = new ArrayList<>();
        System.out.println("----------------------------------");
        System.out.println("Enter CardNumber");
        list.add(sc.next());
        System.out.println("Enter amount");
        list.add(sc.next());
        return list;
    }

    public static void displayMoneyCreditBack() {
        System.out.println("Excess money credit back");
    }

    public static int displayNumberOfDaysRequired() {
        System.out.println( "Enter number days you want to jump" );
        return sc.nextInt();
    }
}
