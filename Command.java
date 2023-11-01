import java.util.Scanner;

public class Command extends Dice{
    
    static int[] diceRoll = new int[2];

    public static void acceptCommand()
    {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter a command (R to roll the dice): ");
            String command = in.nextLine();
            
            switch (command.toLowerCase()) {
                case "r":
                    /* Roll the dice */
                    diceRoll = roll();
                    break;
                default:
                    System.out.println("Invalid command. Please enter 'R' to roll the dice.");
                    break;
            }
        }
    }

    public static int[] getDiceRoll()
    {
        return diceRoll;
    }

}
