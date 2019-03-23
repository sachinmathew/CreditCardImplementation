package Model;

import Utility.GenerateNumber;

public class Card {
    String cardNumber;
    String cvv;
    double cardLimit;
    double apr;
    //Constructor
    public Card(double cardLimit, double apr) {
        cardNumber = GenerateNumber.generateRandomNumber( 12 );
        cvv = GenerateNumber.generateNumber( 3 );
        this.cardLimit = cardLimit;
        this.apr = apr;
    }
    //Getter Functions
    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public double getCardLimit() {
        return cardLimit;
    }

    public double getApr() {
        return apr;
    }
}
