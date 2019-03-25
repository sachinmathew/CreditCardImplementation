package main.Utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
Class to generate unique random numbers for credit cards
 */

public class GenerateNumber {
    //stores list of creditcardNumbers generated
    static Map<String,Integer> creditCardNumbers = new HashMap<>();

    //functions to generate randomcard and cvv numbers
    public static String generateRandomNumber(int length){
        if(length == 3)
            return generateNumber(3);
        String randomNumber = "";
        while(true){
            randomNumber = generateNumber(length);
            if(!creditCardNumbers.containsKey(randomNumber)){
                creditCardNumbers.put( randomNumber,1 );
                break;
            }

        }
        return randomNumber;
    }
    public static String generateNumber(int length){
        String randomNumber = "";
        Random random = new Random();
        for(int i = 0; i < length; i++){
            int number = random.nextInt(10);
            randomNumber += String.valueOf(number);
        }
        return randomNumber;
    }

}
