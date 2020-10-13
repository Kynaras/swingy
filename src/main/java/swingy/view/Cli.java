package swingy.view;

public class Cli {

    private Cli() {
        //Placeholder
    }

    public static final String START_MENU_MESSAGE = "Welcome to Swingy! Let's get you started.\nEnter the number of the option you wish to use.\n1. New game\n2. Load game";
    public static final String START_MENU_ERROR_MESSAGE = "You need to choose either option 1 or 2. Any other option is invalid";
    public static final String NO_SAVE_FILE = "There are currently no saved heroes. You will have to start a new game!";


    public static void display(String string) {
        System.out.println(string);
    }
    
}
