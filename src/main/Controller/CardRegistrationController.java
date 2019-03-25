package main.Controller;

import main.Model.Account;
import main.Model.MainModel;

import java.util.List;

public class CardRegistrationController {
    public static String registerCardMember(List<Object> details){
        return MainModel.createAnAccount(details);

    }
    public static Account getCardMemberDetails(String cardNumber){
        return MainModel.getAccountDetails(cardNumber);
    }
}
