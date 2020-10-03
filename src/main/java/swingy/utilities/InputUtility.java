package swingy.utilities;

import java.util.Scanner;

public class InputUtility {
    
    public static String getUserInput(){
        Scanner userInputScanner;
        String userInput = null;

        userInputScanner = new Scanner(System.in);
        userInput = userInputScanner.nextLine();
        return userInput;
    }

    public static int getMapsize(int heroLevel) {
        return (heroLevel-1)*5+10-(heroLevel%2);
    }

}
