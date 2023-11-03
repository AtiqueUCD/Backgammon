import java.util.Scanner;

public class Command extends Dice{
    
    static int[] diceRoll = new int[2];

    public static void acceptCommand(String command)
    {
        switch (command.toLowerCase()) {
            case "r":
                /* Roll the dice */
                diceRoll = roll();
                break;
            default:
                System.out.println("Invalid command. Please enter 'R/r' to roll the dice or 'Q/q' to Quit");
                break;
        }

    }

    public static int[] getDiceRoll()
    {
        return diceRoll;
    }

}
